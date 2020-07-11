package leetcode.array;

import java.util.Arrays;

/**
 * 
 * Array Partition I
 * Given an array of 2n integers, your task is to group these integers into n pairs of integer, 
 * say (a1, b1), (a2, b2), ..., (an, bn) which makes sum of min(ai, bi) for all i from 1 to n as large as possible.
 * @author jieai706
 * @date 2020-07-09
 */
public class P561 {

	public static void main(String[] args) {
		int[] nums = {3,4,1,5,2};
		int result = arrayPairSum(nums);
		System.out.println(result);
	}
	
	public static int arrayPairSum(int[] nums) {
		Arrays.sort(nums);
		int result = 0;
		for (int i = 0;i < nums.length;i = i + 2) {
			result += nums[i];
		}
		return result;
    }
	
	// Êı×éÅÅĞò
	// Time Limit Exceeded
	public static int arrayPairSum2(int[] nums) {
		int tmp = 0;
		int flag = 0;
		// ÉıĞò,Ã°Åİ
		for (int i = 0;i < nums.length;i ++) {
			for (int j = 0;j < nums.length - 1 - i;j ++) {
				if (nums[j] > nums[j + 1]) {
					tmp = nums[j];
					nums[j] = nums[j + 1];
					nums[j + 1] = tmp;
					flag = 1;
				}
			}
			if (flag == 0)
				break;
		}
		int result = 0;
		for (int i = 0;i < nums.length;i = i + 2) {
			result += nums[i];
		}
		return result;
    }
}
