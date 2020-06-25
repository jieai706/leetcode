package leetcode.array;

// ��Ա�
public class P941 {

	public static void main(String[] args) {
//		int[] A = {0,1,2,3,4,8,9,10,11,12,11};
		int[] A = {5,7,8};
		System.out.println(validMountainArray(A));
	}
	
	/**
	 * 
	 * ����ͷi,j�ֱ���ɽ,һͷ�ϲ�ȥ����һͷ
	 * Ҫ��һ����߷壬����iֻ�ܵ������ڶ�λ��jֻ�ܵ��ڶ�λ
	 * @param A
	 * @return boolean
	 * @author jieai706
	 * @date 2020-06-18
	 */
	public static boolean validMountainArray(int[] A) {
		if (A.length < 3)
			return false;
        for (int i = 0,j = A.length - 1;i < j;) {
        	// i���¾�����i���ߵ���������Ϊֹ
        	if (A[i] < A[i + 1] && i < A.length - 2) {
        		i ++;
        		continue;
        	}
        	// j���£��ߵ���������Ϊֹ
        	if (A[j] < A[j - 1] && j > 1) {
        		j --;
        		continue;
        	}
        	// i��j��������ʱ����ߵ㣬ֻ�д������Ϊtrue�����඼��false
        	if (i == j)
    			return true;
        	return false;
        }
		return true;
    }
}
