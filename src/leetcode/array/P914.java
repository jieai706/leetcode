package leetcode.array;

/**
 * 
 * 最大公约数
 * @author jieai706
 * @date 2020-06-09
 */
public class P914 {

	public static void main(String[] args) {
		int[] deck = {1,1,1,0,0,0,0,0};
		System.out.println(hasGroupsSizeX(deck));
	}
	
	public static boolean hasGroupsSizeX(int[] deck) {
		int length = deck.length;
		if (length < 2)
			return false;
		int[][] tmp = new int[length][2];
		// 初始化tmp
		for (int i = 0;i < length;i ++) {
			tmp[i][0] = -1;
			tmp[i][1] = 1;
		}
		// 不同数字总数
		int disLen = 0;
		// 循环deck赋值
		for (int i = 0;i < length;i ++) {
			// deck[i]去tmp找值，找到了加1
			boolean isExist = false;
			for (int j = 0;j < disLen + 1;j ++) {
				if (tmp[j][0] == deck[i]) {
					tmp[j][1] ++;
					isExist = true;
				}
			}
			if (!isExist) {
				tmp[disLen][0] = deck[i];
				disLen ++;
			}
		}
		
		boolean result = true;
		// 找出最大公约数
		int gcdNum = tmp[0][1];
		for (int i = 1;i < disLen;i ++) {
			gcdNum = gcd(gcdNum, tmp[i][1]);
		}
		// 公约数大于1就是true
		if (gcdNum > 1) {
			result = true;
		} else {
			result = false;
		}
		return result;
    }

	private static int gcd(int x, int y) {
		return x == 0 ? y : gcd(y % x, x);
	}
}
