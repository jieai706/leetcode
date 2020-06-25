package leetcode.array;

// 需对比
public class P941 {

	public static void main(String[] args) {
//		int[] A = {0,1,2,3,4,8,9,10,11,12,11};
		int[] A = {5,7,8};
		System.out.println(validMountainArray(A));
	}
	
	/**
	 * 
	 * 从两头i,j分别上山,一头上不去后换另一头
	 * 要有一个最高峰，所以i只能到倒数第二位，j只能到第二位
	 * @param A
	 * @return boolean
	 * @author jieai706
	 * @date 2020-06-18
	 */
	public static boolean validMountainArray(int[] A) {
		if (A.length < 3)
			return false;
        for (int i = 0,j = A.length - 1;i < j;) {
        	// i上坡就先走i，走到不是上坡为止
        	if (A[i] < A[i + 1] && i < A.length - 2) {
        		i ++;
        		continue;
        	}
        	// j上坡，走到不是上坡为止
        	if (A[j] < A[j - 1] && j > 1) {
        		j --;
        		continue;
        	}
        	// i和j相遇，此时是最高点，只有此种情况为true，其余都是false
        	if (i == j)
    			return true;
        	return false;
        }
		return true;
    }
}
