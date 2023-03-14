package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

public class ClassTest {
    //List<Integer> list = new ArrayList<>(List.of(1, 2, 3, 4));
    List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4));

    /*@BeforeEach
    public void beforeEach() {
        list.add(1);
        list.add(2);
        list.add(3);
    }*/

    @Test
    public void testFirst() {
        list.add(1);
        System.out.println("first = " + list);
        list.add(2);
    }

    @Test
    public void testSecond() {
        System.out.println("second = " + list);
    }
}
