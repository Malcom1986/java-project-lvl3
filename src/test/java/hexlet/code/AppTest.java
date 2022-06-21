package hexlet.code;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AppTest {
    @Test
    void testString() {
        Validator validator = new Validator();
        StringSchema schema = validator.string();

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


}
