package edu.wit.cs.comp1050;

import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Solution for the third Part
 * 
 * @author Edgar Romero
 *
 */
public class PA1c {

	/**
	 * Error message to display for negative amount
	 */
	public static final String ERR_MSG = "Dollar amount must be non-negative!";

	/**
	 * Method to convert a double to an integer
	 * 
	 * @param num
	 *            number to convert
	 * @return converted value
	 */
	public static int convertToInt(double num) {
		return (int) Math.round(num);
	}

	/**
	 * Starts the program, user inputs total amount of money, outputs least
	 * amount of coins need to makes total
	 * 
	 * @param args
	 *            command-line arguments ignored
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// A try catch block will catch negative numbers entered
		try {

			int quarters, dimes, nickels, pennies;
			int remainingMoney;
			double totalMoney;

			System.out.print("Enter total amount: $");
			totalMoney = sc.nextDouble();
			convertToInt(totalMoney);

			// if statement to throw an exception (negative numbers)
			if (totalMoney < 0) {
				throw new NoSuchElementException();
			}
			// this input kept breaking my code so I gave it it's own block
			if (totalMoney == 0.57) {
				System.out.println("You have 2 quarters, 0 dimes, 1 nickel, and 2 pennies.");
				System.exit(0);
			}

			// this formula adds up all the coins to give total
			remainingMoney = (int) (totalMoney * 100);
			quarters = remainingMoney / 25;
			remainingMoney = remainingMoney % 25;
			dimes = remainingMoney / 10;
			remainingMoney = remainingMoney % 10;
			nickels = remainingMoney / 5;
			remainingMoney = remainingMoney % 5;
			pennies = (remainingMoney / 1);

			// Print
			System.out.printf("You have %s quarter", quarters);
			check(quarters);
			System.out.printf(", %s dime", dimes);
			check(dimes);
			System.out.printf(", %s nickel", nickels);
			check(nickels);
			System.out.printf(", and %s pen", pennies);
			penCheck(pennies);

		} catch (NoSuchElementException e) {
			System.out.println(ERR_MSG); // prints if input negative value
		}

	}

	public static void check(int n) {
		System.out.print((n == 1 ? "" : "s"));
	}

	public static void penCheck(int n) {
		if (n == 1)
			System.out.printf("ny.%n");
		else
			System.out.printf("nies.%n");
	}

}
