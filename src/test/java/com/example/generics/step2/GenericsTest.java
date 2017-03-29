package com.example.generics.step2;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class GenericsTest {

    @Test
    public void testList() {
        List<Object> list = new ArrayList<>();
        list.add(2);
        list.add("string");

        Integer v1 = (Integer) list.get(0);
        String v2 = (String) list.get(1);
        assertThat(v1, is(2));
        assertThat(v2, is("string"));
    }

    @Test
    public void testWrongTypesAccessing() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        // We can't add string to the list of integers.
        // Error: no suitable method found for add(java.lang.String)
        //        method java.util.Collection.add(java.lang.Integer) is not applicable
        //        (argument mismatch; java.lang.String cannot be converted to java.lang.Integer)
        // list.add("3");
        list.add(3);
        list.add(4);

        // Cast is unnecessary, compiler already knows that elements are integers.
        Integer v1 = (Integer) list.get(0);
        Integer v2 = list.get(1);
        Integer v3 = list.get(2);
        Integer v4 = list.get(3);
        assertThat(v1, is(1));
        assertThat(v2, is(2));
        assertThat(v3, is(3));
        assertThat(v4, is(4));
    }
}
