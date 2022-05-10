// Concordia University Computer Science -- Arthur Lee Martinez -- 05/05/2021
public class fizzBuzz {
   public static void main(String args[]) {
      int i;
      for (i=1; i<101; i++) {
            String response;
            response = fizz(i);
            System.out.println(response);
      }
   }
      public static String fizz(int current_fizzeration) 
   {
      String iterative_results;
      if (current_fizzeration % 15 == 0) {
          return "FizzBuzz";
   }
      else if (current_fizzeration % 5 == 0) {
         return "Buzz";
   }
      else if (current_fizzeration % 3 == 0) {
         return "Fizz";
   }
      else {
         return String.valueOf(current_fizzeration);
      }
   }
}
