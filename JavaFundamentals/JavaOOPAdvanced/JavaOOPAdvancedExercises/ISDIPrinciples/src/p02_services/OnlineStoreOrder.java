package p02_services;

import java.util.ArrayList;
import java.util.List;

public class OnlineStoreOrder {

    List<NotificationService> notificationServices;

    public OnlineStoreOrder(NotificationService... notificationServices) {
        this.setNotificationServices(notificationServices);
    }

    private void setNotificationServices(NotificationService[] notificationServices) {
        this.notificationServices = new ArrayList<>();

        for (NotificationService notificationService : notificationServices) {
            this.notificationServices.add(notificationService);
        }
    }

    public void process() {
        for (NotificationService notificationService : this.notificationServices) {
            if (!notificationService.isActive()) {
                continue;
            }
            notificationService.sendNotification();
        }
    }
}