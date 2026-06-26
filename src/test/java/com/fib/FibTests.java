/**
 * Tests Fib class and its methods
 * 
 * @author Jacob Whitney
 * @version 1.3
 * @since 1.3 
 */
package com.fib;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FibTests {
    Fib fib = new Fib();

    /**
     * Tests that findFib() identifies the correct Fibonacci value for inputs 0-10.
     */
    @Test
    public void testFindFib() {
        int[] expected = {0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55};
        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], fib.findFib(i));
        }
    }

    /**
     * Test that getMainMenu() returns the correct menu string.
     */
    @Test
    public void testGetMainMenu() {
        String expected = "===========================================\n" +
                "              FIBONACCI METHOD\n" +
                "===========================================\n" +
                "+---+---+-------+\n" + 
                "|   |   |       |\n" + 
                "| 1 | 1 |   2   |\n" + 
                "|   |   |       |\n" + 
                "+---+---+-------+\n" + 
                "|               |\n" + 
                "|               |\n" + 
                "|       3       |\n" + 
                "|               |\n" + 
                "+---------------+\n" + 
                "|               |\n" + 
                "|               |\n" + 
                "|               |\n" + 
                "|       5       |\n" + 
                "|               |\n" + 
                "|               |\n" + 
                "+---------------+\n\n" +
                "Enter an integer to find its value within\n" +
                "the Fibonacci sequence (q to quit)\n" +
                "> ";
                          assertEquals(expected, fib.getMainMenu());
    }

    /**
     * Test that getFibResults() returns the correct result string.
     */
    @Test
    public void testGetFibResults() {
        fib.setN(10);
        fib.setResult();
        
        String expected = "Result: The " + fib.getN() + " place in the sequence is " + 
                          fib.getResult() + "\n";
        
        assertEquals(expected, fib.getFibResults());
    }
}