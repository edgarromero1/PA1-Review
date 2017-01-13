package edu.wit.cs.comp1050;

import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Solution for the fourth Part
 * 
 * @author Edgar Romero
 *
 */
public class PA1d {

	/**
	 * Error message to display for negative amount
	 */
	public static final String ERR_MSG = "The package cannot be shipped!";

	/**
	 * Method to compute shipping cost
	 * 
	 * @param weight,
	 *            assumed to be in (0, 20]
	 * @return cost to ship
	 */
	public static double shippingCost(double weight) {
		double cost = 0;
		//Formula in which weight is turned to cost
		if (weight > 0 && weight <= 1) {
			cost = 3.50;

		} else if (weight > 1 && weight <= 3) {
			cost = 5.50;

		} else if (weight > 3 && weight <= 10) {
			cost = 8.50;

		} else if (weight > 10 && weight <= 20) {
			cost = 10.50;

		}
		return cost;// returns cost based on weight
	}

	/**
	 * Starts the program, user inputs package weight, outputs price of shipping
	 * package
	 * 
	 * @param args
	 *            command-line arguments ignored
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// A try catch block will catch negative numbers entered
		
		try {
			double packageWeight;

			System.out.printf("Enter package weight: ");
			packageWeight = sc.nextDouble();
			
			if (packageWeight <= 0 || packageWeight > 20) {
				throw new NoSuchElementException();
			}
			//print f to have 2 decimals places
			System.out.printf("It will cost $%1.2f to ship this package.%n", shippingCost(packageWeight));

		} catch (NoSuchElementException e) {
			System.out.println(ERR_MSG);
		}
	}

}
