package leetcode.array;

/**
 * 
 * Plus One
 * Given a non-empty array of digits representing a non-negative integer, increment one to the integer.
 * @author jieai706
 * @date 2020-07-22
 */
public class P66 {

	public static void main(String[] args) {
		int[] digits = {9,9,9,9};
		int[] result = plusOne(digits);
		System.out.println(result.length);
	}
	
	public static int[] plusOne(int[] digits) {
		digits[digits.length - 1] += 1;
        for (int i = digits.length - 1;i > 0;i --) {
        	if (digits[i] > 9) {
        		digits[i] = digits[i] - 10;
        		digits[i - 1] += 1;
        	}
        }
        if (digits[0] == 10) {
        	int[] result = new int[digits.length + 1];
        	result[0] = 1;
        	for (int i = 0;i < digits.length;i ++) {
        		result [i + 1] = 0;
        	}
        	return result;
        }
		return digits;
    }
}
