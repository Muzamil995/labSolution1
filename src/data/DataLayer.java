package data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;





public class DataLayer {
    private final Map<String, Double> payments = new HashMap<>();
    private final List<String> notifications = new ArrayList<>();

    public void recordPayment(String user, double amount) {
        payments.put(user, payments.getOrDefault(user, 0.0) + amount);
    }

    public double getPayment(String user) {
        return payments.getOrDefault(user, 0.0);
    }

    public void addNotification(String message) {
        notifications.add(message);
    }

    public List<String> getNotifications() {
        return notifications;
    }
}

