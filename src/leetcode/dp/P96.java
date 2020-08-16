package leetcode.dp;

/**
 * 
 * Unique Binary Search Trees
 * Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n?
 * ������n������n���ڵ㣬1,2,3,4,5������n����Щ�ڵ���ɵĲ�ͬ��̬�Ķ������������˵���������Щ�����õ������о��� 1,2,3,4,5������n��
 * ĳ���ڵ�x��������������ֵȫ<=x����Ȼ���ⲻ���ڵ��ڵ��������������������ֵȫ>=x�����ԣ������ĸ��ڵ��� 1 ��ʱ������������Ϊ 0 ���������ĸ���Ϊ n-1�� �����ĸ��ڵ�Ϊ 2 ��ʱ�� ����������Ϊ 1�� �������ĸ���Ϊ n-2����
 * ���ڵ��  �������ĸ���*�������ĸ���
 * @author jieai706
 * @date 2020-08-07
 */
public class P96 {

	public static void main(String[] args) {
		int n = 3;
		System.out.println(numTrees(n));
	}
	
	// ��dp[i]��ʾi���ڵ���������������и���
	// dp[i] = sum(dp[k] * dp[i - k -1])
	public static int numTrees(int n) {
		if (n == 1)
			return 1;
		int[] dp = new int[n + 1];
		dp[0] = 1;
		dp[1] = 1;
		for (int i = 2;i < n + 1;i ++) {
			for (int j = 0;j < i;j ++) {
				dp[i] += dp[j] * dp[i - j - 1];
			}
		}
        return dp[n];
    }
}
