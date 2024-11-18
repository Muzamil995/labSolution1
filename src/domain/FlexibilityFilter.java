package domain;



public class FlexibilityFilter implements Filter {
    public String process(String input) {
        return input + " | Flexibility Added.";
    }
}

