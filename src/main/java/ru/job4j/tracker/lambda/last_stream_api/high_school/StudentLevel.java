package ru.job4j.tracker.lambda.last_stream_api.high_school;

import ru.job4j.tracker.lambda.streamapi.prof.Address;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StudentLevel {
    public static List<Student> levelOf(List<Student> students, int bound) {
        return students.stream()
                .filter(student -> student.getScore() > bound)
                .filter(Objects::nonNull)
                .sorted(Comparator.comparing(Student::getScore))
                .takeWhile(st -> st.getScore() > bound )
                .collect(Collectors.toList());
    }
}