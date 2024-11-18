package presentation;


import application.ApplicationLayer;
import data.DataLayer;
import domain.TransportService;
import observer.NotificationService;
import observer.User;

public class LayeredArchitectureExample {
    public static void main(String[] args) {
        DataLayer dataLayer = new DataLayer();
        TransportService transportService = new TransportService(dataLayer);
        NotificationService notificationService = new NotificationService();
        ApplicationLayer applicationLayer = new ApplicationLayer(transportService, notificationService);

        User user1 = new User("Alice");
        User user2 = new User("Bob");
        notificationService.attach(user1);
        notificationService.attach(user2);

        applicationLayer.handleTransport("Alice", 10.0, "Public Transport");
        applicationLayer.handleTransport("Bob", 5.0, "Own Convenience");

        System.out.println(transportService.getPaymentInfo("Alice"));
        System.out.println(transportService.getPaymentInfo("Bob"));
        System.out.println("Notifications: " + dataLayer.getNotifications());
    }
}

