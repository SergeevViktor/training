package org.training;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String[] elements = {"Россия", "Франция", "Италия", "Италия", "Россия", "Китай"};
        Map<String, Integer> map = countByElements(elements);

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String key = entry.getKey() + " - ";
            System.out.printf("%s%-5d" , key, entry.getValue());
        }
    }

    public static <K> Map<K, Integer> countByElements(K[] elements) {
        Map<K, Integer> map = new HashMap<>();

        for (K element : elements) {
            map.compute(element, (k, count) -> count == null ? 1 : count + 1);
        }

        return map;
    }
}