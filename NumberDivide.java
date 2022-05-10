import java.util.Scanner;  // Import the Scanner class
class NumberDivide {
    public static void main(String[] args) {
        quotient_response();
    }
    private static Double divided(int x, int y){
        Double x2 = Double.valueOf(x);
        Double y2 = Double.valueOf(y);
        Double z = x2/y2;
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
        
    private static void quotient_response() {
        Scanner scanner = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Enter first number (Dividend)");
        String pre_processed_str = scanner.nextLine();  // Read user input
        if (!isInt(pre_processed_str)) {
            System.out.println("Incorrect format. Please enter digits only.");
            quotient_response();
        }
        else {
            int addend_1 = Integer.parseInt(pre_processed_str);
            System.out.println("Enter second number (Divisor)");
            String pre_processed_str_2 = scanner.nextLine();
            if (!isInt(pre_processed_str_2)) {
                System.out.println("Incorrect format. Please enter digits only.");
                quotient_response();
            }
            else {
                int addend_2 = Integer.parseInt(pre_processed_str_2);  // Read user input
                System.out.print("\033[H\033[2J");
                System.out.flush();
                Double quotient = divided(addend_1, addend_2);
                String formed_string_rsp = (String.format("Quotient of entered numbers: %4.3f", quotient));
                System.out.println(formed_string_rsp);
                }
            }
        }
    }
