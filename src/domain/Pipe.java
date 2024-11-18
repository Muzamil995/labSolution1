package domain;




import java.util.ArrayList;
import java.util.List;

public class Pipe {
    private final List<Filter> filters = new ArrayList<>();

    public void addFilter(Filter filter) {
        filters.add(filter);
    }

    public String process(String input) {
        String result = input;
        for (Filter filter : filters) {
            result = filter.process(result);
        }
        return result;
    }
}

