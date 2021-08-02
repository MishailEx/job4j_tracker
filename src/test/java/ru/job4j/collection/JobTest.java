package ru.job4j.collection;

import org.junit.Test;
import java.util.Comparator;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.assertThat;

public class JobTest {
    @Test
    public void whenReverseComparatorByNameAndPriority() {
        Comparator<Job> cmpNamePriority = new SortedReverseByName().
                thenComparing(new SortedReverseByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Impl task", 1)
        );
        assertThat(rsl, is(1));
    }

    @Test
    public void whenComparatorByName() {
        int rsl = new SortedByName().compare(
                new Job("a", 0),
                new Job("b", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenComparatorById() {
        Job job = new Job("Impl task", 0);
        Job job2 = new Job("Fix bug", 1);
        int rsl = job.compareTo(job2);
        assertThat(rsl, is(-1));
    }

    @Test
    public void whenReverseComparatorByName() {
        int rsl = new SortedReverseByName().compare(
                new Job("a", 0),
                new Job("b", 1)
        );
        assertThat(rsl, is(1));
    }

    @Test
    public void whenReverseComparatorById() {
        int rsl = new SortedReverseByPriority().compare(
                new Job("a", 0),
                new Job("b", 1)
        );
        assertThat(rsl, is(1));
    }

    @Test
    public void whenComparatorByNameAndPriority() {

        Job job = new Job("Impl task", 0);
        Job job2 = new Job("Impl task", 1);
        Comparator<Job> cmpNamePriority = new SortedByName().thenComparing(Job::compareTo);
        int rsl = cmpNamePriority.compare(job, job2);
        assertThat(rsl, is(-1));
    }
}