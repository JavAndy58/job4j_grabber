package ru.job4j.kiss;

import java.util.Comparator;
import java.util.List;

public class MaxMin {
    public <T> T max(List<T> value, Comparator<T> comparator) {
        int counter = 1;
        return minMax(value, counter, comparator);
    }

    public <T> T min(List<T> value, Comparator<T> comparator) {
        int counter = -1;
        return minMax(value, counter, comparator);
    }

    private <T> T minMax(List<T> list, int counter, Comparator<T> comparator) {
        T temp = list.get(0);
        for (T t : list) {
            if ((counter * (comparator.compare(temp, t))) < 0) {
                temp = t;
            }
        }
        return temp;
    }
}