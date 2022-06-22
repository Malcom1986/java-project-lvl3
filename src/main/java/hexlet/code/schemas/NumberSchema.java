package hexlet.code.schemas;

public final class NumberSchema extends BaseSchema {
    public  NumberSchema() {
        addCheck(x -> x instanceof Integer);
    }

    public NumberSchema required() {
        isRequired = true;
        return this;
    }

    public NumberSchema positive() {
        addCheck(x -> (int) x > 0);
        return this;
    }

    public NumberSchema range(int min, int max) {
        addCheck(x -> (int) x >= min && (int) x <= max);
        return this;
    }
}
