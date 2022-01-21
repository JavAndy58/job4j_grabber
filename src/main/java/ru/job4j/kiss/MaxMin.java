package ru.job4j.kiss;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class MaxMin {
    public <T> T max(List<T> value, Comparator<T> comparator) {
        Predicate<Integer> maxPredicate = p -> p < 0;
        return minMax(value, maxPredicate, comparator);
    }

    public <T> T min(List<T> value, Comparator<T> comparator) {
        Predicate<Integer> minPredicate = p -> p > 0;
        return minMax(value, minPredicate, comparator);
    }

    private <T> T minMax(List<T> list, Predicate<Integer> predicate, Comparator<T> comparator) {
        T temp = list.get(0);
        for (T t : list) {
            if (predicate.test(comparator.compare(temp, t))) {
                temp = t;
            }
        }
        return temp;
    }
}