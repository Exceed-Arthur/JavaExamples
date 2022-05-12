class MultiplicationTable { // Instantiate Class to Run Our Main Method In
    public static void main(String[] args) { // Instantiate Main Method
        int i; // Instantiate number to use as for loop iterative
        for (i=1; i<101; i++) {  // Repeat this void function call 99 times
            table_response(i); // Use our instantiated i value as input to print multiplication table on
        }
    }
    private static void table_response(int input) { // Returns nothing. Just prints a multipliacation table (basic)
        int i; // Instantiate number to use as looper variable
        for (i=1; i<101; i++) { // Repeat this action 99 times
            int result = input * i; // Multiply our input value by the iterative value
            System.out.println(String.format("%d x %d = %d", input, i, result)); // Print one line of multiplication table
        }
    }
}
