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
	
	// �ж�����0��0����10
	public static boolean isOneBitCharacter(int[] bits) {
        // ��ͷ��ʼ�����������ڶ�λ�������1����ǰλ����һλ�Ǳ��������������λ�������0����ǰλ�Ǳ���һ��������һλ
		// �жϱ����ĳ����Ƿ�����鳤��һ��
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
