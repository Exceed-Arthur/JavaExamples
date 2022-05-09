import java.util.Scanner;  // Import the Scanner class
class NumberAdd {
    public static void main(String[] args) {
        sum_response();
    }
    private static int added(int x, int y){
        int z = x+y;
        return z;
    }
    private static boolean isInt(String digit_holder) {
        if (digit_holder == null) {
            return false;
        }
        try {
            int integer = Integer.parseInt(digit_holder);
        } catch (NumberFormatException enf) {
            return false;
        }
        return true;
        }
        
    private static void sum_response() {
        Scanner scanner = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Enter first number to add");
        String pre_processed_str = scanner.nextLine();  // Read user input
        if (!isInt(pre_processed_str)) {
            System.out.println("Incorrect format. Please enter digits only.");
            sum_response();
        }
        else {
            int addend_1 = Integer.parseInt(pre_processed_str);
            System.out.println("Enter second number to add");
            String pre_processed_str_2 = scanner.nextLine();
            if (!isInt(pre_processed_str_2)) {
                System.out.println("Incorrect format. Please enter digits only.");
                sum_response();
            }
            else {
                int addend_2 = Integer.parseInt(pre_processed_str_2);  // Read user input
                System.out.print("\033[H\033[2J");
                System.out.flush();
                int summed = added(addend_1, addend_2);
                String formed_string_rsp = (String.format("Sum of entered numbers: %d", summed));
                System.out.println(formed_string_rsp);
                }
            }
        }
    }
