package ru.job4j.tracker.lambda.streamapi.school;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * school
 */
public class School {
    public List<Student> collect(List<Student> students, Predicate<Student> predict) {
        return students.stream().filter(
                predict
                ).collect(Collectors.toList());
    }

    public Map<String, Integer> collectWithMap(List<Student> students) {
        return students.stream()
                    .collect(Collectors.toMap(
                            Student::getSurname,
                            Student::getScore,
                        (existing, replacement) -> existing)
                );
    }
}
