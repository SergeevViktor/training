package org.training;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.averagingDouble;
import static java.util.stream.Collectors.groupingBy;

public class Main {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("Student1", Map.of("Math", 90, "Physics", 85)),
                new Student("Student2", Map.of("Math", 95, "Physics", 88)),
                new Student("Student3", Map.of("Math", 88, "Chemistry", 92)),
                new Student("Student4", Map.of("Physics", 78, "Chemistry", 85))
        );

        Map<String, Double> data = dataProcessing(students);
        for (Map.Entry<String, Double> entry : data.entrySet()) {
            String key = entry.getKey() + ": ";
            System.out.printf("%s%-13f", key, entry.getValue());
        }
    }

    private static Map<String, Double> dataProcessing(List<Student> students) {
        return students.parallelStream()
                .flatMap(student -> student.getGrades().entrySet().stream())
                .collect(groupingBy(Map.Entry::getKey, averagingDouble(Map.Entry::getValue)
                ));
    }
}