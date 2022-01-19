package ru.job4j.kiss;

import java.util.Comparator;
import java.util.List;

public class MaxMin {
    public <T> T max(List<T> value, Comparator<T> comparator) {
//        T max = value.get(0);
//        for (T t : value) {
//            if (comparator.compare(max, t) < 0) {
//                max = t;
//            }
//        }
//        return max;


    }

    public <T> T min(List<T> value, Comparator<T> comparator) {
        T min = value.get(0);
        for (T t : value) {
            if (comparator.compare(min, t) > 0) {
                min = t;
            }
        }
        return min;
    }

    private <T> T minMax(List<T> list, boolean counter) {
        T temp = list.get(0);
        for (T t : list) {
            if (counter) {
                temp = t;
            }
        }
        return temp;
    }
}