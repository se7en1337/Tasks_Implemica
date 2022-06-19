package com.implemica;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Task1Test {
    @Test
    public void test()
    {
        assertEquals(1,Task1.process(1));
        assertEquals(2,Task1.process(2));
        assertEquals(5,Task1.process(3));
        assertEquals(14,Task1.process(4));
        assertEquals(42,Task1.process(5));
        assertEquals(132,Task1.process(6));
    }

}