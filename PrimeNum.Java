import java.util.Scanner; // Import user input class
class PrimeNum {
  public static void main(String[] args) {
    int i;  // Instantiate i for iterative loop
    for (i = 0; i < 999999; i++) { // Test on 1,000,0000 numbers
      if (isPrime(i)) {
        System.out.println(String.format("%d is Prime!", i));
      }
    }
  }
  static Boolean isPrime(Integer n) { // True/False return value
    if (n < 2) {
      return false; // Prime numbers must be greater than 1
    }
    int i; // Instantiate i for iterative loop
    for (i=2; i < 99999; i++) {
      if (((n % i) == 0) && (n != i)) {
          return false;  // Number has a positive divisor other than 1 or itself, so return False
        }
    }
    return true;  // If Number is greater than 1, has no positive divisors other itself or 1, then return True (It is prime)
  }
}
