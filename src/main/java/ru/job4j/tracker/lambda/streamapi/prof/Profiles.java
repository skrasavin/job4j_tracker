package ru.job4j.tracker.lambda.streamapi.prof;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Profiles {
    public List<String> collect(List<Profile> profiles) {
        return profiles.stream()
                .map(address -> address.getAddress().getCity()
                        + " " + address.getAddress().getStreet()
                        + " " + address.getAddress().getHome())
                .collect(Collectors.toList());
    }


    public static void main(String[] args) {
        Address first = new Address("Piter", "Ligovskiy", 7, 13);
        Address second = new Address("Pskov", "Lenina", 12, 20);

        List<Profile> profiles = List.of(new Profile(first), new Profile(second));

        List<String> l = new Profiles().collect(profiles);
        System.out.println(l);
    }
}
