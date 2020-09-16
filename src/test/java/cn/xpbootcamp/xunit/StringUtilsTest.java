package cn.xpbootcamp.xunit;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class StringUtilsTest {
    @Test
    void should_count_cars_correct_when_count_given_a_valid_source() {
        Map<Character, Integer> result = StringUtils.countChar("l1k1j2k02j3lk3kkkk555hhh000lll");
        assertThat(result.get('k')).isEqualTo(7);
        assertThat(result.get('1')).isEqualTo(2);
        assertThat(result.get('5')).isEqualTo(3);
        assertThat(result.get('0')).isEqualTo(4);
        assertThat(result.get('l')).isEqualTo(5);
    }
}