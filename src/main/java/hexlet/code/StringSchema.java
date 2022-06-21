package hexlet.code;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

class StringSchema {

    private List<Predicate<Object>> checks = new ArrayList<>();
    private boolean isRequired = false;

    StringSchema() {
        checks.add(x -> x instanceof String);
    }

    public StringSchema required() {
        isRequired = true;
        checks.add(x -> !x.toString().isBlank());
        return this;
    }

    public StringSchema contains(String substr) {
        checks.add(x -> x.toString().contains(substr));
        return this;
    }

    public boolean isValid(Object data) {
        if (data == null && !isRequired) {
            return true;
        }
        return checks.stream().allMatch(check -> check.test(data));
    }






}
