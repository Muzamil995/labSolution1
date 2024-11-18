package domain;

import data.DataLayer;

 public class TransportService {
    private final DataLayer dataLayer;

    public TransportService(DataLayer dataLayer) {
        this.dataLayer = dataLayer;
    }

    public void processPayment(String user, double amount) {
        dataLayer.recordPayment(user, amount);
    }

    public String getPaymentInfo(String user) {
        return "User: " + user + " has paid: $" + dataLayer.getPayment(user);
    }

    public void notifyUser(String message) {
        dataLayer.addNotification(message);
    }
}