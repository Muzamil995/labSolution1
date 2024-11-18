package domain;



public class PaymentFilter implements Filter {
    public String process(String input) {
        return input + " | Payment Processed.";
    }
}

