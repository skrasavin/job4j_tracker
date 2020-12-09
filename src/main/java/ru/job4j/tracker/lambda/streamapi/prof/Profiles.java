package ru.job4j.tracker.lambda.streamapi.prof;

import java.util.List;
import java.util.stream.Collectors;

public class Profiles {
    public List<String> collect(List<Profile> profiles) {
        return profiles.stream()
                .map(address -> address.getAddress().getCity()
                        + " " + address.getAddress().getStreet()
                        + " " + address.getAddress().getHome()
                        + "/" + address.getAddress().getApartment())
                .sorted()
                .distinct()
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        Address firstAdd = new Address("Piter", "Ligovskiy", 7, 13);
        Address secondAdd = new Address("Pskov", "Lenina", 12, 20);
        Address thirdAdd = new Address("Piter", "Ligovskiy", 1, 13);
        Address fourthAdd = new Address("Pskov", "Lenina", 12, 20);

        List<Profile> profiles = List.of(new Profile(firstAdd), new Profile(secondAdd), new Profile(thirdAdd),
                                new Profile(fourthAdd));

        List<String> l = new Profiles().collect(profiles);
        System.out.println(l);
    }
}
