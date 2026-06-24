/**
 * Defines program's interface for user interaction with
 * the Fibonacci Sequence
 * 
 * @author Jacob Whitney
 * @version 1.3
 * @since 1.3 
 */
package com.fib;

import java.util.Scanner;

public class Fib {
    // Attributes
    private int n = 0;
    private int result = findFib(n);

    // Getters and Setters
    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public int getResult() {
        return result;
    }

    public void setResult() {
        this.result = findFib(n);
    }

    public void setResult(int result) {
            this.result = result;
    }

    // Processor methods

    /**
     * Manages the bulk of the processing to produce results of the 
     * Fibonacci Sequence.
     */
    public void startFibSequence() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.printf(getMainMenu());
            
            while (true) {
                String input = scanner.nextLine();

                // Quit
                if (input.equals("q") || input.equals("Q")) {
                    quit();
                }

                // Begin Fibonacci Sequence
                try {
                    n = Integer.parseInt(input);
                } catch (NumberFormatException e) {
                    System.out.println("[ERROR] Not a valid integer\n");
                    System.out.println("Please try again");
                    System.out.printf("> ");
                    continue;
                }

                result = findFib(n);
                System.out.printf(getFibResults());
            }
        }
    }

    /**
     * Runs system exit to end the program.
     */
    public void quit() {
        System.out.println("Exiting, goodbye...");
        System.exit(0);
    }

    /**
     * Returns the value in the Fibonacci Sequence of the n term parameter.
     * 
     * @param   n   an integer representing a term within the Fibonacci Sequence.
     * @return      n if less than or equal to 1, otherwise add F(n-1) + F(n-2).
     */
    public int findFib(int n) {
        if ( n <= 1 ) {
            return n;
        }
        return findFib(n - 1) + findFib(n-2);
    }
    
    // Printer methods

    /**
     * Returns the Main Menu to be printed to the terminal.
     * 
     * @return      menu header and instructions in a string.
     */
    public String getMainMenu() {
        return "===========================================\n" +
               "              FIBONACCI METHOD\n" +
               "===========================================\n" +
               "Enter an integer to find its value within\n" +
               "the Fibonacci sequence (q to quit)\n" +
               "> ";
    }

    /**
     * Returns results of Fibonacci Sequence in easy to read string.
     * 
     * @return      results as a human readable string.
     */
    public String getFibResults() {
        return "Result: The " + n + " place in the sequence is " + 
               result + "\n" +
               "Try another integer (q to quit)\n" +
               "> ";
    }


}