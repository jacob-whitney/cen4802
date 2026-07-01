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
    private Integer n = 0;
    private Integer result = findFib(n);

    // Constructor
    Fib(String[] args) {
        if ( validateArgs(args) ) {
            String input = args[0];
            this.n = validateInput(input);
            if ( this.n == null ) {
                System.out.println("[ERROR] Argument entered not a valid integer");
                System.out.println("Please try again.");
            }

            // Begin Fibonacci Sequence
            setResult();
            System.out.printf(getFibResults());
        } else {
            System.out.println("[ERROR] Invalid argument(s)");
            System.out.println();
            System.out.println("Get an integer's value in the Fibonacci Sequence");
            System.out.println("by passing it as a single argument when running");
            System.out.println("the program.");
            System.out.println();
            System.out.println("Or run the program without any arguments to run");
            System.out.println("it interactively.");
        }
    }

    Fib() {}

    // Getters and Setters
    public Integer getN() {
        return n;
    }

    public void setN(Integer n) {
        this.n = n;
    }

    public Integer getResult() {
        return result;
    }

    public void setResult() {
        this.result = findFib(n);
    }

    public void setResult(Integer result) {
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

                // Validate user input
                this.n = validateInput(input);
                if ( this.n == null ) {
                    System.out.println("[ERROR] Not a valid integer");
                    System.out.println("Please try again");
                    System.out.printf("> ");
                    continue;
                }

                // Begin Fibonacci Sequence
                setResult();
                System.out.printf(getFibResults());
                System.out.printf("Try another integer (q to quit)\n> ");
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
    public Integer findFib(Integer n) {
        if ( n <= 1 ) {
            return n;
        }
        return findFib(n - 1) + findFib(n-2);
    }


    public boolean validateArgs(String[] args) {
        if ( args.length > 1) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * 
     * @param input User input to find integer value in fib sequence
     * @return      
     */
    public Integer validateInput(String input) {
        try {
            Integer parse = Integer.parseInt(input);
            n = validateN(parse);
            return n;
        } catch (NumberFormatException e) {
            System.out.println(e);
            return null;
        }
    }

    public Integer validateN(Integer n) {
        if ( n >= 0 ) {
            return n;
        } else {
            return null;
        }
    }
    
    // Printer methods

    /**
     * Returns the Main Menu to be printed to the terminal.
     * 
     * @return      menu header and instructions in a string.
     */
    public String getMainMenu() {
        return  "===========================================\n" +
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
               result + "\n";
    }


}