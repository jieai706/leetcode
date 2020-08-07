package leetcode.dp;

/**
 * 
 * Range Sum Query - Immutable
 * Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
 * @author jieai706
 * @date 2020-08-07
 */
public class P303 {

	private int[] nums;
	public static void main(String[] args) {
		int[] array = {-2, 0, 3, -5, 2, -1};
		P303 obj = new P303(array);
		int param_1 = obj.sumRange(0,2);
		System.out.println(param_1);
	}
	
	// nums[i]记录到i为止的和
	// j-i=nums[j]-nums[i-1]
	public P303(int[] nums) {
		for(int i = 1; i < nums.length; i++)
	        nums[i] += nums[i - 1];
	    this.nums = nums;
    }
    
    public int sumRange(int i, int j) {
        if (i == 0)
        	return nums[j];
        return nums[j] - nums[i - 1];
    }
}
