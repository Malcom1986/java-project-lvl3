package hexlet.code.schemas;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public abstract class BaseSchema {
    private List<Predicate<Object>> checks = new ArrayList<>();
    protected boolean isRequired = false;

    protected final void addCheck(Predicate<Object> check) {
        checks.add(check);
    }

    public final boolean isValid(Object data) {
        if (data == null && !isRequired) {
            return true;
        }
        return checks.stream().allMatch(check -> check.test(data));
    }

}
