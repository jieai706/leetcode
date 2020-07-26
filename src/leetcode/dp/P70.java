package leetcode.dp;

/**
 * 
 * Climbing Stairs
 * @author jieai706
 * @date 2020-07-26
 */
public class P70 {

	public static void main(String[] args) {
		int n = 15;
		System.out.println(climbStairs(n));
	}
	
	// 斐波那契数列
	// DP
	public static int climbStairs(int n) {
		if (n == 1)
			return 1;
		if (n == 2)
			return 2;
		int[] dp = new int[n];
		dp[0] = 1;
    	dp[1] = 2;
        for (int i = 2;i < n;i ++) {
        	dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n - 1];
    }
	
	// 斐波那契数列
	// 递归会Time Limit Exceeded
	public static int climbStairs2(int n) {
        if (n == 1)
        	return 1;
        if (n == 2)
        	return 2;
		return climbStairs(n - 1) + climbStairs(n - 2);
    }
}
