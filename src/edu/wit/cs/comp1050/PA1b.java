package edu.wit.cs.comp1050;

import java.util.NoSuchElementException;
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
	 * @param args
	 *            command-line arguments ignored
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// A try catch block will catch negative numbers entered

		try {
			int quarters, dimes, nickels, pennies;
			double totalMoney;

			System.out.print("Enter number of quarters: ");
			quarters = sc.nextInt();
			System.out.print("Enter number of dimes: ");
			dimes = sc.nextInt();
			System.out.print("Enter number of nickels: ");
			nickels = sc.nextInt();
			System.out.print("Enter number of pennies: ");
			pennies = sc.nextInt();

			// if statement to throw an exception (negative numbers)
			if (quarters < 0 || dimes < 0 || nickels < 0 || pennies < 0) {
				throw new NoSuchElementException();
			}

			// this formula adds up all the coins to give total
			totalMoney = (0.25 * quarters) + (0.10 * dimes) + (0.05 * nickels) + (0.01 * pennies);

			// Print f is used to format two decimal spaced
			System.out.printf("You have $%1.2f in coins.%n", totalMoney);

		} catch (NoSuchElementException e) {
			System.out.println(ERR_MSG); // error message that gets printed if
											// negative values found
		}

	}

}
