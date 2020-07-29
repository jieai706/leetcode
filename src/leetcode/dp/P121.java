package leetcode.dp;

/**
 * 
 * Best Time to Buy and Sell Stock
 * @author jieai706
 * @date 2020-07-29
 */
public class P121 {

	public static void main(String[] args) {
		int[] prices = {7};
		System.out.println(maxProfit(prices));
	}
	
	// DP
	// ״̬ת�Ʒ��̣�dp[i] = max(dp[i - 1],prices[i] - min)
	// min��¼��iΪֹ����Сֵ
	public static int maxProfit(int[] prices) {
		int min = 0;
        int result = 0; 
        for(int i = 0;i < prices.length;i ++){   
            if(prices[i]<min) min = prices[i];
            result = Math.max((prices[i] - min), result);
        }
        return result;
    }
	
	// ��AC
	public static int maxProfit2(int[] prices) {
        int result = 0;
        // ˫��ѭ����
        for (int i = 0;i < prices.length;i ++) {
        	for (int j = i;j < prices.length;j ++) {
        		if (prices[j] - prices[i] > result)
        			result = prices[j] - prices[i];
        	}
        }
		return result;
    }
}
