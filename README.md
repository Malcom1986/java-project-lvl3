### Hexlet tests and linter status:
[![Actions Status](https://github.com/Malcom1986/java-project-lvl3/workflows/hexlet-check/badge.svg)](https://github.com/Malcom1986/java-project-lvl3/actions)
[![Maintainability](https://api.codeclimate.com/v1/badges/b414ad09d5a6f9fec44f/maintainability)](https://codeclimate.com/github/Malcom1986/java-project-lvl3/maintainability)
[![Test Coverage](https://api.codeclimate.com/v1/badges/b414ad09d5a6f9fec44f/test_coverage)](https://codeclimate.com/github/Malcom1986/java-project-lvl3/test_coverage)
[![Java CI](https://github.com/Malcom1986/java-project-lvl3/actions/workflows/java%20ci.yml/badge.svg)](https://github.com/Malcom1986/java-project-lvl3/actions/workflows/java%20ci.yml)
# Валидатор данных

Валидатор данных – библиотека, с помощью которой можно проверять корректность любых данных.

Пример использования:

```java

Validator v = new Validator();

// строки
StringSchema schema = v.string().required();

schema.isValid("what does the fox say"); // true
schema.isValid(""); // false

// числа
NumberSchema schema = v.number().required().positive();

schema.isValid(-10); // false
schema.isValid(10); // true

// объект Map с поддержкой проверки структуры
Map<String, BaseSchema> schemas = new HashMap<>();
schemas.put("name", v.string().required());
schemas.put("age", v.number().positive());

MapSchema schema = v.map().sizeof(2).shape(schemas);

Map<String, Object> human1 = new HashMap<>();
human1.put("name", "Kolya");
human1.put("age", 100);
schema.isValid(human1); // true

Map<String, Object> human2 = new HashMap<>();
human2.put("name", "");
human2.put("age", null);
schema.isValid(human1); // false
```