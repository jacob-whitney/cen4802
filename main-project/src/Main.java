import java.util.Scanner;

public class Main {
    /**
     * Returns the value in the Fibonacci Sequence of the n term parameter.
     * @param   n   an integer representing a term within the Fibonacci Sequence.
     * @return      n if less than or equal to 1, otherwise add F(n-1) + F(n-2).
     */
    static int fibo(int n) {
        if ( n <= 1 ) {
            return n;
        }
        return fibo(n - 1) + fibo(n-2);
    }
    
    public static void main(String[] args) {
        // Main Menu
        System.out.println("===========================================");
        System.out.println("            FIBONACCI METHOD");
        System.out.println("===========================================");
        System.out.println("Enter an integer to find its value within");
        System.out.println("the Fibonacci sequence (q to quit)");
        System.out.printf("> ");

        Scanner scanner = new Scanner(System.in);
        String input;
        int n;

        // Process N in Fibonacci Sequence
        while (true) {
            input = scanner.nextLine();

            // Quit
            if (input.equals("q") || input.equals("Q")) {
                System.out.println("Exiting, goodbye...");
                System.exit(0);
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

            System.out.printf("Result: The " + n + " place in the sequence is ");
            System.out.println(fibo(n));
            System.out.println();
            System.out.printf("Try another integer (q to quit)\n> ");
        }











    }
}