package ru.job4j.assertj;

import org.assertj.core.data.Index;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class SimpleConvertTest {

    @Test
    void checkArray() {
        SimpleConvert simpleConvert = new SimpleConvert();
        String[] array = simpleConvert.toArray("first", "second", "three", "four", "five");
        assertThat(array).hasSize(5)
                .contains("second")
                .contains("first", Index.atIndex(0))
                .containsAnyOf("zero", "second", "six")
                .doesNotContain("first", Index.atIndex(1));
    }

    @Test
    void checkList() {
        SimpleConvert simpleConvert = new SimpleConvert();
        List<String> list = simpleConvert.toList("one", "four", "six", "two", "five");
        assertThat(list).isNotEmpty()
                .hasSize(5)
                .contains("two", "five")
                .contains("four", Index.atIndex(1))
                .containsExactlyInAnyOrder("six", "five", "two", "one", "four")
                .startsWith("one")
                .endsWith("two", "five");
    }

    @Test
    void checkSet() {
        SimpleConvert simpleConvert = new SimpleConvert();
        Set<String> set = simpleConvert.toSet("Gorbunov", "Davidov", "Popov", "Ivanov", "Smirnov", "Antonov");
        assertThat(set).isNotEmpty()
                .hasSize(6)
                .contains("Ivanov", "Smirnov")
                .containsExactlyInAnyOrder("Gorbunov", "Davidov", "Popov", "Ivanov", "Smirnov", "Antonov")
                .element(2).isEqualTo("Popov");
    }

    @Test
    void checkMap() {
        SimpleConvert simpleConvert = new SimpleConvert();
        Map<String, Integer> map = simpleConvert.toMap("two", "one", "three", "six", "eight");
        assertThat(map).isNotEmpty()
                .hasSize(5)
                .containsKey("one")
                .containsValues(4, 0, 1, 2, 3)
                .doesNotContainKey("four")
                .containsEntry("six", 3);
    }

}