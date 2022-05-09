import java.util.Scanner;  // Import the Scanner class
class NumberAdd {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Enter first number to add");
        int addend_1 = Integer.parseInt(scanner.nextLine());  // Read user input
        System.out.println("Enter second number to add");
        int addend_2 = Integer.parseInt(scanner.nextLine());  // Read user input
        System.out.print("\033[H\033[2J");
        System.out.flush();
        int summed = added(addend_1, addend_2);
        String formed_string_rsp = (String.format("Sum of entered numbers: %d", summed));
        System.out.println(formed_string_rsp);
    }
    public static int added(int x, int y){
        int z = x+y;
        return z;
    }
}
