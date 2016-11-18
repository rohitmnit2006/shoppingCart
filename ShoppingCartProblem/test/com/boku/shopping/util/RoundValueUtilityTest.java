package com.boku.shopping.util;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * 
 * @author Rohit Gupta
 */
public class RoundValueUtilityTest {

    @Test
    public void testRoundoff() {
        assertEquals(27.80, RoundValueUtility.roundoff(27.82), 0.0009);
        assertEquals(27.85, RoundValueUtility.roundoff(27.83), 0.0009);
        assertEquals(27.90, RoundValueUtility.roundoff(27.875), 0.0009);
    }

    @Test
    public void testTruncate() {
        assertEquals(27.86, RoundValueUtility.truncate(27.8565), 0);
        assertEquals(27.80, RoundValueUtility.truncate(27.800004), 0);
    }

    @Test
    public void testTruncate_toString() {
        assertEquals(27.80, RoundValueUtility.truncate(27.8), 0);
        assertEquals(27.00, RoundValueUtility.truncate(27d), 0);
    }

}
