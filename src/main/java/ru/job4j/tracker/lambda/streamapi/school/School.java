package ru.job4j.tracker.lambda.streamapi.school;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class School {
    public Map<String, Integer> collect(List<Student> students, Predicate<Student> predict) {
        return students.stream().filter(
                predict
        ).collect(Collectors.toMap(Student::getSurname, Student::getScore));
    }
}
