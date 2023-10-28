package org.example;

import org.junit.Test;

import static org.example.W03_Arrays.containsDuplicate;
import static org.junit.Assert.*;

public class W03_ArraysTest {
    @Test
    public void containsDuplicateTrue() {
        int[] array = { 1, 2, 3, 4, 1};
        assertTrue(containsDuplicate(array));
    }

    @Test
    public void containsDuplicateFalse() {
        int[] array = { 1, 2, 3, 4, 5 };
        assertFalse(containsDuplicate(array));
    }

    @Test
    public void containsDuplicateEmpty() {
        int[] array = {};
        assertFalse(containsDuplicate(array));
    }

    @Test
    public void containsDuplicateLongArray() {
        int[] array = new int[1000];
        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }
        array[array.length - 1] = 0;
        assertTrue(containsDuplicate(array));
    }

    @Test
    public void containsDuplicateOneElement() {
        int[] array = { 1 };
        assertFalse(containsDuplicate(array));
    }

    @Test
    public void containsDuplicateMultipleDuplicates() {
        int[] array = { 1, 2, 3, 1, 1, 1 };
        assertTrue(containsDuplicate(array));
    }
}