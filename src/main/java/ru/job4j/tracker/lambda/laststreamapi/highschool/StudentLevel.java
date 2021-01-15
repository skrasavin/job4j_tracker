package ru.job4j.tracker.lambda.laststreamapi.highschool;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * studLevel
 */
public class StudentLevel {
    public static List<Student> levelOf(List<Student> students, int bound) {
        return students.stream()
                .filter(student -> student.getScore() > bound)
                .sorted(Comparator.comparing(Student::getScore))
                .takeWhile(st -> st.getScore() > bound)
                .collect(Collectors.toList());
    }
}