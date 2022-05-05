//. Concordia Computer Science Department
//  Arthur Lee Martinez, May 5 2022
//  Task : Write a Java program to print 'Hello, {User}'
		


import java.util.Scanner;  // Import the Scanner class
import java.util.Arrays;

public class HelloUser {
	public static void main(String[] args) {
		String userName = GrabName();
		System.out.println(String.format("Hello, %s", userName));
	}
	private static String GrabName() {
		Scanner scan_object_nameRequest = new Scanner(System.in); //Create A Scanner Object linked to system in
		System.out.println("Please type your name and hit enter.");
		String userName = scan_object_nameRequest.nextLine(); // Read user input
		System.out.println("Please type your name again and hit enter.");
		String userNameConfirm = scan_object_nameRequest.nextLine(); // Read user input again to confirm
		if (userName.equalsIgnoreCase(userNameConfirm)) {
			if (userName.contains(" ") != false) {
			userName = (userName.toLowerCase()).substring(0, 1).toUpperCase() + userName.substring(1).toLowerCase();
			String ConfirmationResponse = String.format("Thank you! Your name is: %s", userName);
			System.out.println(ConfirmationResponse);
			return userNameConfirm;
			else {
				String[] partsOfName_pre = (userName.replaceAll("  ", " ")).replaceAll("  ", " ").split(" ");
				String[] partsofName_post;
				for (i=0; i < (partsOfName_pre.length()); i++;) {
					
				}
			}
		}
		else {
			System.out.println("Please try again. Your responses did not match.");
			GrabName();
			return "Redo";  // The method returns a string. But this will bypass checks and simulate late binding because the return statement never gets called. Recursive!
		}
	}
}
