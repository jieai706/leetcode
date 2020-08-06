package leetcode.dp;

/**
 * 
 * House Robber
 * @author jieai706
 * @date 2020-08-02
 */
public class P198 {

	public static void main(String[] args) {
		int[] nums = {2,7,9,3,1};
		System.out.println(rob(nums));
	}
	
	// ״̬ת�Ʒ��̣�dp[i] = max(dp[i - 2] + i,dp[i - 1])
	public static int rob(int[] nums) {
        int[] dp = new int[nums.length];
        if (nums.length == 0)
        	return 0;
        if (nums.length == 1)
        	return nums[0];
        if (nums.length == 2)
        	return Math.max(nums[0], nums[1]);
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2;i < nums.length;i ++) {
        	dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
		return dp[nums.length - 1];
    }
}
