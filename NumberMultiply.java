import java.util.Scanner;  // Import Scanner class

class NumberMultiply {
    public static void main(String[] args) {
        UserMultiplyInterface();
    }
    public static boolean isNumber(String inputted_num) { // Check if String can be be formatted
        if (inputted_num == null) {
            return false;
        }
        else {
            try {
                int dub2 = Integer.parseInt(inputted_num); // If this can't be declared as an Int or Dub return False
                Double dub = Double.valueOf(dub2);
                return true;
            } catch (Exception e){
                try {
                    Double dub = Double.parseDouble(inputted_num);
                    return true;
                } catch (Exception d) {
                    try {
                        Double dub = Double.valueOf(Integer.parseInt(inputted_num));
                        return true;
                    } catch (Exception zz) {
                    return false;
                    }
                }
            }
        }
    }
    public static void UserMultiplyInterface() {
        String num1_pre_processed; // Declare first multiplier
        Scanner numScan = new Scanner(System.in); // Instantiate Scanner Object to get user input
        System.out.println("Enter first multiplier (number)"); // Prompt User
        num1_pre_processed = numScan.nextLine(); // Get the line the user typed
        if (isNumber(num1_pre_processed)) {
            Double num1;  
            Double num2; //Declare 2 Decimal Numbers for accurate multiplication 
            try {
                num1 = Double.parseDouble(num1_pre_processed);
            } catch (Exception f) {
                num1 = Double.valueOf(Integer.parseInt(num1_pre_processed));
            } // User may insert decimals or integers
            System.out.println("Enter second multiplier (number)"); // Prompt User
            String num2_pre_processed = numScan.nextLine(); // Get the line the user typed
            if (isNumber(num2_pre_processed)) {
                try {
                    num2 = Double.parseDouble(num2_pre_processed);
                } catch (Exception c) {
                    num2 = Double.valueOf(Integer.parseInt(num2_pre_processed));
                  } // User may insert decimals or integers
                Double valRes = num1 * num2; // Instantiate final decimal number value of multiplication
                String Respone = String.format("%.4f * %.4f = %.4f", num1, num2, valRes); // Format response with variables
                clearConsole();
                System.out.println(Respone);
            }
            else {
                System.out.println("You must submit actual numbers in decimal or integer format. Try again. ");
                UserMultiplyInterface(); // Recursive call, restart process if user fails
            }
        }
        else {
            UserMultiplyInterface();
        }
    }
    public static void clearConsole(){
        //Clears Screen in java
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            }
            else {
                Runtime.getRuntime().exec("clear");
            }} catch (Exception ex) {}
        }
}
