package com.dkk.rxjava.samplerxjava.utils;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by deepak on 3/3/17.
 *
 * String util test cases
 */
public class StringUtilsTest {
    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void testIsEmptyWithNullValue() {
        boolean isEmpty = StringUtils.isEmpty(null);
        assertEquals(isEmpty,true);
    }

    @Test
    public void testIsEmptyWithEmptyValue() {
        boolean isEmpty = StringUtils.isEmpty("");
        assertEquals(isEmpty,true);
    }

    @Test
    public void testIsEmptyWithValue() {
        boolean isEmpty = StringUtils.isEmpty("abcd");
        assertEquals(isEmpty,false);
    }

    @Test
    public void testIsEmptyWithSingleCharacter() {
        boolean isEmpty = StringUtils.isEmpty("a");
        assertEquals(isEmpty,false);
    }

    @After
    public void tearDown() throws Exception {

    }

}