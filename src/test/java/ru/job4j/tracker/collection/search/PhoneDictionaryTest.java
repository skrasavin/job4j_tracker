package ru.job4j.tracker.collection.search;

import org.junit.Test;

import java.util.ArrayList;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PhoneDictionaryTest {
    @Test
    public void whenFindByName() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(new Person("Petr", "Arsentev", "534872", "Bryansk"));
        phones.add(new Person("Ivan", "Kiselev", "224155", "Kostroma"));
        ArrayList<Person> persons = phones.find("224");
        assertThat(persons.get(0).getSurname(), is("Kiselev"));
    }

    public void testAdd() {
    }

    public void testFind() {
    }
}