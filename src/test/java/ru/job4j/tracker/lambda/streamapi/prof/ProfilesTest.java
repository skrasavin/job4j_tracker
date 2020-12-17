package ru.job4j.tracker.lambda.streamapi.prof;

import org.junit.Test;

import java.lang.ref.PhantomReference;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ProfilesTest {

    @Test
    public void testCollect() {
        Address firstAdd = new Address("Piter", "Ligovskiy", 7, 13);
        Address secondAdd = new Address("Pskov", "Lenina", 12, 20);
        Address thirdAdd = new Address("Piter", "Ligovskiy", 7, 13);
        Address fourthAdd = new Address("Saratov", "Koroleva", 1, 20);

        List<Profile> profiles = List.of(new Profile(firstAdd), new Profile(secondAdd), new Profile(thirdAdd),
                new Profile(fourthAdd));
        List<Address> l = new Profiles().collect(profiles);
        Address extend = l.get(0);
        assertThat(extend, is(firstAdd));
    }

    @Test
    public void testMatrix() {
        Integer[][] matrix = {{1, 2}, {3, 4}};
        List<Integer> expected = List.of(1, 2, 3, 4);
        List<Integer> output = new Profiles().testList(matrix);
        assertThat(expected, is(output));
    }
}