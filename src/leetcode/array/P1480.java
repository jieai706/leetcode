package leetcode.array;

/**
 * 
 * Running Sum of 1d Array
 * @author jieai706
 * @date 2020-07-19
 */
public class P1480 {

	public static void main(String[] args) {
		int[] nums = {3,1,2,10,1};
		int [] result = runningSum(nums);
		System.out.println(result.length);
	}
	
	public static int[] runningSum(int[] nums) {
		int[] result = new int[nums.length];
		result[0] = nums[0];
		for (int i = 1;i < nums.length;i ++) {
			result[i] = result[i - 1] + nums[i];
		}
		return result;
    }
}
