package ru.job4j.tracker.collection.departments;

import org.junit.Test;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class DepDescCompTest {

    @Test
    public void compare() {
        int rsl = new DepDescComp().compare(
                "K2/SK1/SSK2",
                "K2/SK1/SSK1"
        );
        assertThat(rsl, equalTo(0));
    }

    @Test
    public void whenUpDepartmentGoBefore() {
        int rsl = new DepDescComp().compare(
                "K2",
                "K2/SK1"
        );
        assertThat(rsl, equalTo(0));
    }

    @Test
    public void whenUpDepGoAfter() {
        int rsl = new DepDescComp().compare(
                "K1",
                "K2/SK1"
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenUpDepGoAfter1() {
        int rsl = new DepDescComp().compare(
                "K2",
                "K2/SK1"
        );
        assertThat(rsl, equalTo(0));
    }

}