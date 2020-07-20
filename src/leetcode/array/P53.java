package leetcode.array;

/**
 * 
 * Maximum Subarray
 * Given an integer array nums, 
 * find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
 * @author jieai706
 * @date 2020-07-19
 */
public class P53 {

	public static void main(String[] args) {
		int[] nums = {-2,1};
		System.out.println(maxSubArray(nums));
	}

	private static int maxSubArray(int[] nums) {
		int result = nums[0];
		for (int i = 0;i < nums.length;i ++) {
			int subResult = nums[i];
			if (subResult > result)
				result = subResult;
			for (int j = i + 1;j < nums.length;j ++) {
				subResult += nums[j];
				if (subResult > result)
					result = subResult;
			}
		}
		return result;
	}
}
