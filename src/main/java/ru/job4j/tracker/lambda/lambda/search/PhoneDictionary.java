package ru.job4j.tracker.lambda.lambda.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {

        Predicate<Person> compareName = person -> person.getName().equals(key);
        Predicate<Person> compareSurname = person -> person.getSurname().equals(key);
        Predicate<Person> comparePhone = person -> person.getPhone().equals(key);
        Predicate<Person> compareAddress = person -> person.getAddress().equals(key);
        Predicate<Person> combine = compareName.or(compareSurname).or(comparePhone).or(compareAddress);
        ArrayList<Person> result = new ArrayList<>();
        for (Person person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}