package org.example;

import org.apache.commons.lang3.ArrayUtils;

public class SomeClass {
    public static int sum(int a, int b) {
        return a + b;
    }

    public static int dif(int a, int b) {
        return a - b;
    }

    private static int[] right(int[] numbers, int... values) {
        var numbersWithoutValues = ArrayUtils.clone(numbers);
        for (var value : values) {
            numbersWithoutValues = ArrayUtils.removeAllOccurrences(numbersWithoutValues, value);
        }
        return numbersWithoutValues;
    }
}
