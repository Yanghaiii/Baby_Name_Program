package com.babynameprogram;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    Main m;

    @BeforeEach
    void setUp() {
        m = new Main();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void read_Data() {
        m.read_Data("data/Baby_Names.csv");

        assertEquals(2085158, m.namelist.size());
    }

    @Test
    void read_Incorrect_Column() {
        m.read_Data("data/testfile1.csv");
        assertEquals(0,m.namelist.size());
    }

    @Test
    void read_More_Column() {
        m.read_Data("data/testfile2.csv");
        assertNotEquals(0, m.namelist.size()); // for 2 data exists
        //assertEquals(2, m.namelist.size());
    }

    @Test
    void read_Wrong_DataType() {
        m.read_Data("data/testfile3.csv");
        assertEquals(0, m.namelist.size());
    }

    @Test
    void read_Empty_File() {
        m.read_Data("data/testfile4.csv");
        assertEquals(0,m.namelist.size());
    }
}