package edu.wit.cs.comp1050;

public class Prime {
	
	/**
	 * Returns true if the supplied
	 * value is prime (i.e. no integer
	 * [2, n) divides it evenly)
	 * 
	 * @param n number to consider
	 * @return true if n is prime, false otherwise
	 */
	public static boolean isPrime(int n) {
		if(n<=0){
			return false;
		}
		if(n%2 ==0){
			
		}
		return true; 
	}
	
	/**
	 * Returns the first prime number that
	 * occurs *after* the supplied value
	 * 
	 * @param n number (assumed to be >0)
	 * @return first prime that occurs after n
	 */
	public static int primeAfter(int n) {
		if(isPrime(n)){
			return n+1;
		}
		return n; // replace with your code (hint: isPrime is quite useful here)
	}
	
	/**
	 * Ensures that the next instance of
	 * the Prime class will have a sequence 
	 * number of 1 and will begin with 
	 * the first prime that follows the 
	 * supplied value
	 * 
	 * @param initValue value to seed the prime sequence
	 */
	public static void resetSequence(int initValue) {
		// replace with your code
	}
	
	/**
	 * Constructs the next prime
	 * number according to the
	 * currently set sequence
	 * 
	 * seed = sequence seed
	 * number = last number + 1
	 * value = prime after last prime 
	 */
	public Prime() {
		// replace with your code
	}
	
	/**
	 * Gets the sequence seed of
	 * this Prime
	 * 
	 * @return sequence seed
	 */
	public int getSequenceSeed() {
		return 0; // replace with your code
	}
	
	/**
	 * Gets the sequence number
	 * of this Prime
	 * 
	 * @return sequence number
	 */
	public int getSequenceNumber() {
		return 0; // replace with your code
	}
	
	/**
	 * Gets the sequence value
	 * of this Prime
	 * 
	 * @return sequence value
	 */
	public int getValue() {
		return 0; // replace with your code
	}
	
	/**
	 * Returns a textual representation
	 * of this prime in the following
	 * format: "seq(seed, number) = value"
	 * 
	 * @return "seq(seed, number) = value"
	 */
	@Override
	public String toString() {
		return ""; // replace with your code
	}
	
}
