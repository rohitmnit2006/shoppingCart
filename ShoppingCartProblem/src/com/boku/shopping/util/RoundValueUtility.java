/**
 * 
 */
package com.boku.shopping.util;

import java.text.DecimalFormat;

/**
 * A utility class for rounding operations.
 * 
 * @author Rohit Gupta
 *
 */
public class RoundValueUtility {

    private static final double ROUND_OFF = 0.05;

    /** Rounds off a double value to the nearest 0.05 */
    public static double roundoff(Double value) {
        if (null == value) {
            return 0.0D;
        }
        return (int) (value / ROUND_OFF + 0.5) * ROUND_OFF;
    }

    /** Convert formated string to double value */
    public static double truncate(Double value) {
        if (null == value) {
            return 0.0D;
        }
        return Double.parseDouble(toString(value));
    }

    /** Truncates a double value to two decimal places in string */
    public static String toString(Double value) {
        if (null == value) {
            return null;
        }
        return new DecimalFormat("#0.00").format(value);
    }
}
