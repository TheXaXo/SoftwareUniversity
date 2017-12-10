package app.exam.service;

import app.exam.domain.dto.json.EmployeeOrdersJSONExportDTO;
import app.exam.domain.dto.json.ItemJSONExportDTO;
import app.exam.domain.dto.json.OrderJSONExportDTO;
import app.exam.domain.dto.xml.OrderItemXMLImportDTO;
import app.exam.domain.dto.xml.OrderXMLImportDTO;
import app.exam.domain.entities.*;
import app.exam.parser.interfaces.ModelParser;
import app.exam.repository.EmployeeRepository;
import app.exam.repository.ItemsRepository;
import app.exam.repository.OrderItemRepository;
import app.exam.repository.OrderRepository;
import app.exam.service.api.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {
    private OrderRepository orderRepository;
    private EmployeeRepository employeeRepository;
    private ItemsRepository itemsRepository;
    private OrderItemRepository orderItemRepository;
    private ModelParser modelParser;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository, EmployeeRepository employeeRepository, ItemsRepository itemsRepository, ModelParser modelParser, OrderItemRepository orderItemRepository) {
        this.orderRepository = orderRepository;
        this.employeeRepository = employeeRepository;
        this.itemsRepository = itemsRepository;
        this.modelParser = modelParser;
        this.orderItemRepository = orderItemRepository;
    }

    @Override
    public void create(OrderXMLImportDTO dto) throws ParseException {
        String employeeName = dto.getEmployee();
        Employee employee = this.employeeRepository.findFirstByName(employeeName);

        if (employee == null) {
            throw new IllegalArgumentException("Employee does not exist.");
        }

        for (OrderItemXMLImportDTO itemInList : dto.getOrderItems().getItems()) {
            Item item = this.itemsRepository.findFirstByName(itemInList.getName());

            if (item == null) {
                throw new IllegalArgumentException("One or more of the items does not exist.");
            }
        }

        DateFormat format = new SimpleDateFormat("d/M/y H:m", Locale.ENGLISH);
        Order order = new Order();
        order.setCustomer(dto.getCustomer());
        order.setDate(format.parse(dto.getDateString()));
        order.setType(dto.getType());
        order.setEmployee(employee);

        Set<OrderItem> orderItems = new HashSet<>();

        for (OrderItemXMLImportDTO item : dto.getOrderItems().getItems()) {
            Item itemToAdd = this.itemsRepository.findFirstByName(item.getName());
            OrderItem orderItem = new OrderItem();
            orderItem.setItem(itemToAdd);
            orderItem.setOrder(order);
            orderItem.setQuantity(item.getQuantity());

            orderItems.add(orderItem);
        }

        order.setOrderItems(orderItems);
        this.orderRepository.save(order);
        this.orderItemRepository.save(orderItems);
    }

    @Override
    public EmployeeOrdersJSONExportDTO exportOrdersByEmployeeAndOrderType(String employeeName, String orderType) {
        List<Order> orders = this.orderRepository.findAllByEmployeeNameAndType(employeeName, OrderType.valueOf(orderType));

        Comparator<Order> comparator = (o1, o2) -> {
            int result;
            BigDecimal o1TotalPrice = o1.getTotalPrice();
            BigDecimal o2TotalPrice = o2.getTotalPrice();

            result = o2TotalPrice.compareTo(o1TotalPrice);

            if (result == 0) {
                result = Integer.compare(o2.getItemsCount(), o1.getItemsCount());

                if (result == 0) {
                    result = Integer.compare(o1.getId(), o2.getId());
                }
            }

            return result;
        };

        orders = orders.stream()
                .sorted(comparator)
                .collect(Collectors.toList());

        EmployeeOrdersJSONExportDTO employeeOrders = new EmployeeOrdersJSONExportDTO();
        employeeOrders.setEmployeeName(employeeName);

        List<OrderJSONExportDTO> allOrders = new ArrayList<>();

        for (Order order : orders) {
            OrderJSONExportDTO orderDtoToAdd = new OrderJSONExportDTO();
            orderDtoToAdd.setCustomer(order.getCustomer());
            List<ItemJSONExportDTO> itemsDtoToAdd = new ArrayList<>();

            for (OrderItem item : order.getOrderItems()) {
                ItemJSONExportDTO itemToAdd = new ItemJSONExportDTO();
                itemToAdd.setPrice(item.getItem().getPrice());
                itemToAdd.setName(item.getItem().getName());
                itemToAdd.setQuantity(item.getQuantity());

                itemsDtoToAdd.add(itemToAdd);
            }

            orderDtoToAdd.setItems(itemsDtoToAdd);
            allOrders.add(orderDtoToAdd);
        }

        employeeOrders.setOrders(allOrders);
        return employeeOrders;
    }
}