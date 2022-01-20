package ru.job4j.kiss;

import org.junit.Assert;
import org.junit.Test;
import java.util.List;

public class MaxMinTest {

    @Test
    public void whenMaxList() {

        MaxMin maxMin = new MaxMin();
        List<Integer> integerList = List.of(1, 10, 100, 200);
        Integer actual = 200;
        Integer expected = maxMin.max(integerList, Integer::compareTo);
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void whenMinList() {
        MaxMin maxMin = new MaxMin();
        List<Integer> integerList = List.of(1, 10, 100, 200);
        Integer actual = 1;
        Integer expected = maxMin.min(integerList, Integer::compareTo);
        Assert.assertEquals(actual, expected);
    }
}