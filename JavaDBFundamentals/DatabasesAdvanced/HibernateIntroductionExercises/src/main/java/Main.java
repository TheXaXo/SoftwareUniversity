import entities.Address;
import entities.Employee;
import entities.Project;
import entities.Town;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@SuppressWarnings("unchecked")
public class Main {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager entityManager = factory.createEntityManager();

        entityManager.getTransaction().begin();
        employeesMaximumSalaries(entityManager);
        entityManager.getTransaction().commit();
    }

    private static void removeObjects(EntityManager entityManager) {
        List<Town> allTowns = entityManager
                .createQuery("SELECT t FROM Town t WHERE LENGTH(t.name) > 5")
                .getResultList();

        for (Town town : allTowns) {
            entityManager.detach(town);
            town.setName(town.getName().toLowerCase());
            entityManager.merge(town);
        }
    }

    private static void checkIfNameIsInDb(String name, EntityManager entityManager) {
        List<Employee> employee = entityManager
                .createQuery("SELECT e FROM Employee e WHERE CONCAT(e.firstName, ' ', e.lastName) = ?")
                .setParameter(0, name)
                .getResultList();

        if (employee.size() == 0) {
            System.out.println("no");
        } else {
            System.out.println("yes");
        }
    }

    private static void firstNameOfEmployees(EntityManager entityManager) {
        List<String> firstNames = entityManager
                .createQuery("SELECT e.firstName FROM Employee e WHERE e.salary > 50000")
                .getResultList();

        firstNames.forEach(System.out::println);
    }

    private static void employeesFromDepartment(EntityManager entityManager) {
        List<Employee> employees = entityManager
                .createQuery("SELECT e FROM Employee e WHERE e.department.id = 6 ORDER BY e.salary ASC, e.id ASC")
                .getResultList();

        for (Employee employee : employees) {
            System.out.printf("%s %s from %s - $%s%n",
                    employee.getFirstName(),
                    employee.getLastName(),
                    employee.getDepartment().getName(),
                    employee.getSalary());
        }
    }

    private static void addNewAddressAndUpdateEmployee(String lastName, EntityManager entityManager) {
        Address address = new Address();
        address.setText("Vitoshka 15");
        entityManager.persist(address);

        Employee employee = (Employee) entityManager
                .createQuery("SELECT e FROM Employee e WHERE e.lastName = ?")
                .setParameter(0, lastName)
                .getSingleResult();
        employee.setAddress(address);
    }

    private static void addressesWithEmployeeCount(EntityManager entityManager) {
        List<Address> addresses = entityManager
                .createQuery("SELECT a FROM Address a ORDER BY a.employees.size DESC, a.town.id ASC")
                .setMaxResults(10)
                .getResultList();

        for (Address address : addresses) {
            System.out.printf("%s, %s - %d employees%n",
                    address.getText(),
                    address.getTown().getName(),
                    address.getEmployees().size());
        }
    }

    private static void getEmployeeWithProjects(int id, EntityManager entityManager) {
        Employee employee = (Employee) entityManager
                .createQuery("SELECT e FROM Employee e WHERE e.id = ?")
                .setParameter(0, id)
                .getSingleResult();

        List<Project> projects = employee.getProjects().stream()
                .sorted(Comparator.comparing(a -> a.getName()))
                .collect(Collectors.toList());

        System.out.printf("%s %s - %s%n",
                employee.getFirstName(),
                employee.getLastName(),
                employee.getJobTitle());

        for (Project project : projects) {
            System.out.println("    " + project.getName());
        }
    }

    private static void last10StartedProjects(EntityManager entityManager) {
        List<Project> projects = entityManager
                .createQuery("SELECT p FROM Project p ORDER BY p.startDate DESC, p.name ASC")
                .setMaxResults(10)
                .getResultList();

        for (Project project : projects) {
            System.out.printf("Project name: %s%n\tProject Description: %s%n\tProject Start Date: %s%n\tProject End Date: %s%n",
                    project.getName(),
                    project.getDescription(),
                    project.getStartDate(),
                    project.getEndDate());
        }
    }

    private static void increaseSalaries(EntityManager entityManager) {
        List<Employee> employees = entityManager
                .createQuery("SELECT e FROM Employee e WHERE e.department.id IN (1, 2, 4, 11)")
                .getResultList();

        for (Employee employee : employees) {
            employee.setSalary(employee.getSalary().add(employee.getSalary().multiply(new BigDecimal("0.12"))));
            System.out.printf("%s %s ($%s)\n",
                    employee.getFirstName(),
                    employee.getLastName(),
                    employee.getSalary());
        }
    }

    private static void removeTowns(String townName, EntityManager entityManager) {
        Town townToBeDeleted = (Town) entityManager
                .createQuery("SELECT t FROM Town t WHERE t.name = ?")
                .setParameter(0, townName)
                .getSingleResult();

        List<Address> addressesInTown = entityManager
                .createQuery("SELECT a FROM Address a WHERE a.town.name = ?")
                .setParameter(0, townName)
                .getResultList();

        int addressesCount = addressesInTown.size();

        addressesInTown.stream()
                .forEach(a -> entityManager.remove(a));
        entityManager.remove(townToBeDeleted);

        System.out.printf("%d address in %s deleted", addressesCount, townName);
    }

    private static void findEmployeesByFirstName(String pattern, EntityManager entityManager) {
        List<Employee> employees = entityManager
                .createQuery("SELECT e FROM Employee e WHERE e.firstName LIKE ?")
                .setParameter(0, pattern + "%")
                .getResultList();

        for (Employee employee : employees) {
            System.out.printf("%s %s - %s - ($%s)%n",
                    employee.getFirstName(),
                    employee.getLastName(),
                    employee.getJobTitle(),
                    employee.getSalary());
        }
    }

    private static void employeesMaximumSalaries(EntityManager entityManager) {
        List<Object[]> departments = entityManager
                .createQuery("SELECT d.name, MAX(e.salary) FROM Department d JOIN Employee e ON d.id = e.department.id GROUP BY e.department.id HAVING MAX(e.salary) NOT BETWEEN 30000 AND 70000")
                .getResultList();

        for (Object[] innerArray : departments) {
            System.out.printf("%s - %s%n",
                    innerArray[0], innerArray[1]);
        }
    }
}