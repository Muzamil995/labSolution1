package domain;



public class RestrictionFilter implements Filter {
    public String process(String input) {
        return input + " | Restriction of time filter Applied.";
    }
}

