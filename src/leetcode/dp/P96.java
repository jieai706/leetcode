package leetcode.dp;

/**
 * 
 * Unique Binary Search Trees
 * Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n?
 * 给出的n代表有n个节点，1,2,3,4,5，……n，这些节点组成的不同形态的二叉查找树，是说中序遍历这些树，得到的序列就是 1,2,3,4,5，……n。
 * 某根节点x，它的左子树的值全<=x（当然本题不存在等于的情况），它的右子树的值全>=x，所以，当它的根节点是 1 的时候，左子树个数为 0 ，右子树的个数为 n-1， 当它的根节点为 2 的时候， 左子树个数为 1， 右子树的个数为 n-2……
 * 根节点的  左子树的个数*右子树的个数
 * @author jieai706
 * @date 2020-08-07
 */
public class P96 {

	public static void main(String[] args) {
		int n = 3;
		System.out.println(numTrees(n));
	}
	
	// 用dp[i]表示i个节点下面二叉树的排列个数
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
