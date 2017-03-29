package com.example.generics.step1;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class RawTypesTest {

    @Test
    @SuppressWarnings("unchecked")
    public void testList() {
        List list = new ArrayList();
        list.add(2);
        list.add("string");

        Integer v1 = (Integer) list.get(0);
        String v2 = (String) list.get(1);
        assertThat(v1, is(2));
        assertThat(v2, is("string"));
    }

    @Test(expected = ClassCastException.class)
    @SuppressWarnings("unchecked")
    public void testWrongTypesAccessing() {
        List list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add("3");
        list.add(4);

        Integer v1 = (Integer) list.get(0);
        Integer v2 = (Integer) list.get(1);
        Integer v3 = (Integer) list.get(2);
        Integer v4 = (Integer) list.get(3);
        assertThat(v1, is(1));
        assertThat(v2, is(2));
        assertThat(v3, is(3));
        assertThat(v4, is(4));
    }
}
