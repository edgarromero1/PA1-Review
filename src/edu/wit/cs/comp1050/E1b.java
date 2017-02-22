package edu.wit.cs.comp1050;

import java.util.Scanner;

/**
 * !! DO NOT CHANGE ANY CODE IN THIS FILE !!
 */
public class E1b {

	/**
	 * Uses terminal input to allow for
	 * the user to request any number
	 * of primes for any seed
	 * 
	 * @param args command-line arguments, ignored
	 */
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		final Scanner in = new Scanner(System.in);

		boolean morePrimes;
		do {
			System.out.printf("Next seed: ");
			final int seed = in.nextInt();
			System.out.printf("Number of primes: ");
			final int n = in.nextInt();
			morePrimes = (seed>0 && n>0);
			
			if (morePrimes) {
				Prime.resetSequence(seed);
				for (int i=0; i<n; i++) {
					System.out.printf("%s%n", new Prime());
				}
			}
			
		} while (morePrimes);
	}

}
