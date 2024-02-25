package org.training;

import java.util.Arrays;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Integer[] after = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Integer[] before1 = filter(after, integer -> (integer * 2 < 5));
        Integer[] before2 = filter(after, integer -> (integer % 3 == 0));

        System.out.println("Фильтр №1 ------------");
        for (Integer integer : before1) {
            System.out.println(integer);
        }
        System.out.println("Фильтр №2 ------------");
        for (Integer integer : before2) {
            System.out.println(integer);
        }
    }

    public static <T> T[] filter(T[] array, Function<? super T, Boolean> filter) {
        int marker = 0;

        for (int i = 0; i < array.length; i++) {
            if (!filter.apply(array[i])) {
                marker++;
            } else {
                array[i - marker] = array[i];
            }
        }

        return Arrays.copyOf(array, array.length - marker);
    }
}