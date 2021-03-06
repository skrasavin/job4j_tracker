package ru.job4j.tracker.lambda.streamapi.prof;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * profiles
 */
public class Profiles {
    public List<Address> collect(List<Profile> profiles) {
        return profiles.stream()
                .map(Profile::getAddress)
                .sorted(Comparator.comparing(Address::getCity))
                .distinct()
                .collect(Collectors.toList());

    }

    public List<Integer> testList(Integer[][] matrix) {
        return Arrays.stream(matrix).flatMap(Arrays::stream)
                .collect(Collectors.toList());
    }
}
