package edu.wit.cs.comp1050;

import java.util.Scanner;

/**
 * Solution for the fifth Part
 * 
 * @author Edgar Romero
 *
 */
public class PA1e {

	/**
	 * Counts the number of upper case characters within the supplied string
	 * 
	 * @param s
	 *            input string
	 * @return number of upper case characters
	 */
	public static int numUpperCase(String s) {
		int upperCaseCount = 0;
		// a for loop is used so the string condition is tested before executing
		for (int i = 0; i < s.length(); i++) { 
			for (char c = 'A'; c <= 'Z'; c++) {
				if (s.charAt(i) == c) { 
					upperCaseCount++; //counts uppercase 
				}
			}
		}
		return upperCaseCount;
	}

	/**
	 * Starts the program, user inputs string, outputs the number of uppercase
	 * letters
	 * 
	 * @param args
	 *            command-line arguments ignored
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String input;

		System.out.print("Enter a string: ");
		input = sc.nextLine();
		// if no string is entered 
		if (input.equals(null) || input.equals("")){
			System.out.printf("There are no uppercase characters.%n");
			System.exit(0);
		}
		// if string has 0 uppercases
		else if (numUpperCase(input) == 0){
			System.out.printf("There are no uppercase characters.%n");
			System.exit(0);
		}
		// if string has exactly 1 uppercase
		else if (numUpperCase(input) == 1){
			System.out.printf("There is %d uppercase character in the string.%n", numUpperCase(input));
		}

		else {
			System.out.printf("There are %d uppercase characters in the string.%n", numUpperCase(input));
		}
	}
}

