package edu.wit.cs.comp1050;
import java.util.Scanner;

/**
 * Solution for the second Part
 * 
 * @author Edgar Romero
 *
 */
public class PA1b {
	
	/**
	 * Error message to display for any non-negative counts 
	 */
	public static final String ERR_MSG = "All coin counts must be non-negative!";


	/**
	 * Starts the program, user inputs coins, outputs the total worth of coins
	 * 
	 * @param args command-line arguments ignored
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int quarterAmount, dimeAmount, nickelAmount, pennieAmount;
		double totalMoney;
		
		System.out.print("Enter number of quarters: ");
		quarterAmount = sc.nextInt();
		sc.nextLine();
		System.out.print("Enter number of dimes: ");
		dimeAmount = sc.nextInt();
		sc.nextLine();
		System.out.print("Enter number of nickels: ");
		nickelAmount = sc.nextInt();
		sc.nextLine();
		System.out.print("Enter number of pennis: ");
		pennieAmount = sc.nextInt();
		sc.nextLine();
		
		
		totalMoney = (0.25 * quarterAmount) + (0.10 * dimeAmount) 
				+ (0.05 * nickelAmount) + (0.01 * pennieAmount);
		
		System.out.print("You have $");
		System.out.printf("%1.2f", totalMoney); 
		System.out.print(" in coins.");
		
		
		
	}

}
