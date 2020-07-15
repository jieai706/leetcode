package leetcode.integer;

/**
 * 
 * Reverse Integer
 * Given a 32-bit signed integer, reverse digits of an integer.
 * int range -2147483648~2147483647
 * @author jieai706
 * @date 2020-07-16
 */
public class P7 {

	public static void main(String[] args) {
		int x = -123;
		System.out.println(reverse(x));
	}
	
	// 由低到高取模
	// 如果结果用int接收会反转后可能会溢出
	// 溢出返回0
	public static int reverse(int x) {
		Long result = 0l;
		while (x != 0) {
			result = result * 10 + x % 10;
			x = x/10;
		}
		if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE)
			return 0;
        return result.intValue();
    }
}
