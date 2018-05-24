package Heroes_Villains.utils;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RandomNumTest {

    private RandomNum testRandom;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getNum() {
        assertEquals(0, testRandom.getNum(1));
        assertNotEquals(5, testRandom.getNum(3));
    }
}