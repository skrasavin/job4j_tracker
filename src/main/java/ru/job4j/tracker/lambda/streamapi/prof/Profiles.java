package ru.job4j.tracker.lambda.streamapi.prof;

import java.util.List;
import java.util.stream.Collectors;

public class Profiles {
    public List<Address> collect(List<Profile> profiles) {
        return profiles.stream()
                .map(Profile::getAddress)
                .distinct()
                .sorted()
                .collect(Collectors.toList());

    }
}
