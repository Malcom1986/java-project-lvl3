package hexlet.code.schemas;

import java.util.Map;

public final class MapSchema extends BaseSchema {

    public MapSchema() {
        addCheck(x -> x instanceof Map);
    }

    public MapSchema required() {
        isRequired = true;
        return this;
    }

    public MapSchema sizeof(int size) {
        addCheck(x -> ((Map) x).size() == size);
        return this;
    }

    public MapSchema shape(Map<String, BaseSchema> schemas) {
        addCheck(x -> schemas
                        .entrySet()
                        .stream()
                        .allMatch(entry -> {
                            var key = entry.getKey();
                            var sc = entry.getValue();
                            return sc.isValid(((Map) x).get(key));
                        })
        );
        return this;
    }

}
