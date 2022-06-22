package hexlet.code;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class AppTest {
    @Test
    void testString() {
        var validator = new Validator();
        var schema = validator.string();

        assertThat(schema.isValid("")).isTrue();
        assertThat(schema.isValid(null)).isTrue();
        assertThat(schema.isValid(3)).isFalse();

        schema.required();

        assertThat(schema.isValid(null)).isFalse();
        assertThat(schema.isValid(null)).isFalse();
        assertThat(schema.isValid("hello")).isTrue();

        schema.contains("some");

        assertThat(schema.isValid("hello")).isFalse();
        assertThat(schema.isValid("some string")).isTrue();

        schema.contains("good");
        assertThat(schema.isValid("good")).isFalse();
        assertThat(schema.isValid("some good string")).isTrue();
    }

    @Test
    void testNumber() {
        var validator = new Validator();
        var schema = validator.number();

        assertThat(schema.isValid(null)).isTrue();
        assertThat(schema.isValid("word")).isFalse();

        schema.required();

        assertThat(schema.isValid(null)).isFalse();
        assertThat(schema.isValid(0)).isTrue();
        assertThat(schema.isValid(-5)).isTrue();
        assertThat(schema.isValid(9)).isTrue();

        schema.positive();

        assertThat(schema.isValid(-5)).isFalse();
        assertThat(schema.isValid(9)).isTrue();

        schema.range(5, 20);

        assertThat(schema.isValid(4)).isFalse();
        assertThat(schema.isValid(5)).isTrue();
        assertThat(schema.isValid(20)).isTrue();
        assertThat(schema.isValid(25)).isFalse();
    }
}
