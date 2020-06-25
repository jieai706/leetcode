package leetcode.array;

/**
 * 
 * We have two special characters. The first character can be represented by one bit 0. 
 * The second character can be represented by two bits (10 or 11).
 * 
 * Now given a string represented by several bits.
 * Return whether the last character must be a one-bit character or not. The given string will always end with a zero.
 * @author jieai706
 * @date 2020-06-25
 */
public class P717 {

	public static void main(String[] args) {
		int[] bits = {1, 1, 1, 0};
//		int[] bits = {1, 1, 0};
		System.out.println(isOneBitCharacter(bits));
	}
	
	// 判断最后的0是0还是10
	public static boolean isOneBitCharacter(int[] bits) {
        // 从头开始遍历至倒数第二位，如果是1，则当前位和下一位是编码二，调至下下位；如果是0，则当前位是编码一，跳至下一位
		// 判断遍历的长度是否和数组长度一致
		int i = 0;
		for (i = 0;i < bits.length - 1;) {
			if(bits[i] == 1)
				i = i + 2;
			else
				i ++;
		}
		// i = 4
		// i = 2
		return i == bits.length - 1;
    }
}
