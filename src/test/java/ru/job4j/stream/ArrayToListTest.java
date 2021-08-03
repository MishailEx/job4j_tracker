package ru.job4j.stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ArrayToListTest {
    @Test
    public void whenArrayToList() {
        Integer[][] matrix = {
                {2, 5, 6},
                {5, 6, 8}
        };
        ArrayToList array = new ArrayToList();
        List<Integer> list = array.arrToList(matrix);
        List<Integer> list2 = Arrays.asList(2, 5, 6, 5, 6, 8);
        assertThat(list, is(list2));
    }

}