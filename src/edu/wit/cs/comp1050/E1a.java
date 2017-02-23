package edu.wit.cs.comp1050;

public class E1a {
	
	/**
	 * Error to output if non-integers are supplied
	 */
	public static final String ERR_USAGE = "Input any number of integers.";
	
	/**
	 * Error to output if no inputs are supplied to the biggest method
	 */
	public static final String ERR_EMPTY = "No integers supplied.";
	
	/**
	 * Returns the largest value
	 * found in a supplied array
	 * 
	 * @param nums input array
	 * @return largest value in nums, null if nums is empty
	 */
	public static Integer biggestNum(int[] nums) {
		
		if(nums.length != 0){
			int biggest = nums[0];
			for(int i = 0; i < nums.length; i++){
				if(nums[i] > biggest){
					biggest = nums[i];
				}
			}
			return biggest;
		}else {
			return null;
		}
		
	}
	/**
	 * Returns a string with
	 * the largest value in a
	 * supplied array, or an
	 * error if empty
	 * 
	 * @param nums input array
	 * @return largest value in nums, ERR_EMPTY if nums is empty
	 */
	public static String biggest(int[] nums) {
		
		if (nums.length != 0){
			String biggest;
			biggest = biggestNum(nums).toString();
			return biggest;
		} else
		
		return ERR_EMPTY; // replace with your code (hint: use biggestNum above)
	}
	
	/**
	 * Converts an array of strings
	 * to an array of integers
	 * 
	 * @param args input array
	 * @return array of integers, null if there was a non-integer in args
	 */
	public static int[] convertToNums(String[] args) {
		int[] numbers = new int [args.length];
		
		if (args.length == 2){
			try{
			for(int i = 0; i < args.length; i ++){
				 numbers[i] = Integer.parseInt(args[i]);	 
			}
			return numbers;
			}catch (Exception e){
				return null;
			}

		} else
		return null; 
	}

	/**
	 * Outputs the largest value of a list
	 * of integers supplied via command-line
	 * arguments
	 * 
	 * @param args command-line arguments: num1 num2 ...
	 */
	public static void main(String[] args) {
		
	}

}
