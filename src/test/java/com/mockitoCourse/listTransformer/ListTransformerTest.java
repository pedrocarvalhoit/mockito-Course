package com.mockitoCourse.listTransformer;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.containsInAnyOrder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ListTransformerTest {

    private ListTransformer listTransformer;

    @BeforeEach
    public void setUp(){
        listTransformer = new ListTransformer();
    }

    @Test
    public void containsLetterTest(){
        Item a = new Item(10, "raspberry");
        Item b = new Item(2, "banana");
        Item c = new Item(1, "apricot");
        List<Item> items = Arrays.asList(a, b, c);

        CharSequence cs = "b";
        List<Item> itemsWithB = listTransformer.contaisLetter(cs, items);
        List<Item> expected = Arrays.asList(a, b);

        assertNotNull(itemsWithB);
        assertEquals(2, itemsWithB.size());
        assertEquals(itemsWithB, expected);
        assertThat(new ArrayList<>(itemsWithB), contains(expected.toArray()));
    }

    @Test
    public void containsLetterTestSorted(){
        Item a = new Item(10, "raspberry");
        Item b = new Item(2, "banana");
        Item c = new Item(1, "apricot");
        List<Item> items = Arrays.asList(a, b, c);

        CharSequence cs = "b";
        List<Item> itemsWithB = listTransformer.containsLetterandSort(cs, items);
        List<Item> expected = Arrays.asList(a, b);

        assertNotNull(itemsWithB);
        assertEquals(2, itemsWithB.size());
        assertThat(new ArrayList<>(itemsWithB), containsInAnyOrder(expected.toArray()));


    }

}