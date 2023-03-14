package org.example;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class SomeClassTest {

    @Test
    public void testSum() {
        var expected = 6;
        var actual = SomeClass.sum(3, 2);
        assertThat(expected).isEqualTo(actual);

    }

    @Test
    public void testDif() {
        var expected = 1;
        var actual = SomeClass.dif(3, 2);
        assertThat(expected).isEqualTo(actual);
    }
}
