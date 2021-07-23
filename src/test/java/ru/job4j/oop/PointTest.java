package ru.job4j.oop;

import junit.framework.TestCase;
import org.junit.Test;

import static org.hamcrest.Matchers.closeTo;
import static org.junit.Assert.assertThat;

public class PointTest {

    @Test
    public void when000to200then2() {
        Point a = new Point(0, 0, 0);
        Point b = new Point(2, 0, 0);
        double rsl = a.distance3d(b);
        assertThat(rsl, closeTo(2, 0.001));
    }
}