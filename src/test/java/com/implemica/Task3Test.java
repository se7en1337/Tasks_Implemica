package com.implemica;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Task3Test {
    @Test
    public void test()
    {
        assertEquals(648,Task3.computing(Task3.factorial()));
    }

}