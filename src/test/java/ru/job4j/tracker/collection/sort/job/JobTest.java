package ru.job4j.tracker.collection.sort.job;


import org.junit.Test;

import java.util.*;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.assertThat;

public class JobTest {
    @Test
    public void whenCompatorByNameAndIncrease() {
        Comparator<Job> cmpNamePriority = new SortByName().thenComparing(Job::compareTo);
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenCompatorByNameAndIncreaseSecondComp() {
        Comparator<Job> cmpNamePriority = new SortByName().thenComparing(Job::compareTo);
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Impl task", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenCompatorByPriorityAndIncrease() {
        Comparator<Job> cmpNamePriority = Job::compareTo;
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenCompatorByNameAndDecrease() {
        Comparator<Job> cmpNamePriority = new SortByName().
                thenComparing(Collections.reverseOrder());
        int rsl = cmpNamePriority.compare(
                new Job("Fix task", 2),
                new Job("Fix task", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenCompatorByPriorityAndDecrease() {
        Comparator<Job> cmpNamePriority = Collections.reverseOrder();
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 1),
                new Job("Fix bug", 2)
        );
        assertThat(rsl, greaterThan(0));
    }
}