package hexlet.code.schemas;

public final class StringSchema extends BaseSchema {

    public StringSchema() {
        addCheck(x -> x instanceof String);
    }

    public StringSchema required() {
        isRequired = true;
        addCheck(x -> !x.toString().isBlank());
        return this;
    }

    public StringSchema contains(String substring) {
        addCheck(x -> x.toString().contains(substring));
        return this;
    }

    public StringSchema minLength(int minLength) {
        addCheck(x -> x.toString().length() >= minLength);
        return this;
    }
}
