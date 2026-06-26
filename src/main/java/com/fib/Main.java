/**
 * Start a new fibonacci interface where users enter a number 
 * and get its value in the Fibonacci Sequence as an output.
 * 
 * @author Jacob Whitney
 * @version 1.3
 * @since 1.0 
 */
package com.fib;

public class Main {   
    public static void main(String[] args) {
        if ( args == null || args.length == 0 ) {
            Fib fib = new Fib();
            fib.startFibSequence();
        } else {
            new Fib(args);
        }
    }
}