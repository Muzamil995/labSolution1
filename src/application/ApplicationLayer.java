package application;



import data.DataLayer;
import domain.Pipe;
import domain.TransportService;
import domain.FlexibilityFilter;
import domain.PaymentFilter;
import domain.RestrictionFilter;
import observer.NotificationService;

public class ApplicationLayer {
    private final TransportService transportService;
    private final NotificationService notificationService;

    public ApplicationLayer(TransportService transportService, NotificationService notificationService) {
        this.transportService = transportService;
        this.notificationService = notificationService;
    }

    public void handleTransport(String user, double payment, String caseType) {
        Pipe pipe = new Pipe();

        if (caseType.equals("Public Transport")) {
            pipe.addFilter(new RestrictionFilter());
            pipe.addFilter(new PaymentFilter());
        } else if (caseType.equals("Own Convenience")) {
            pipe.addFilter(new FlexibilityFilter());
            pipe.addFilter(new PaymentFilter());
        } else if (caseType.equals("University Tap")) {
            pipe.addFilter(new RestrictionFilter());
        }

        String result = pipe.process(caseType);
        System.out.println(result);

        transportService.processPayment(user, payment);
        transportService.notifyUser("Payment of $" + payment + " made for " + caseType);
        notificationService.notifyAllObservers("New update: " + result);
    }
}

