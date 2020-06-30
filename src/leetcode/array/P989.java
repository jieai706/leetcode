package leetcode.array;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 
 * For a non-negative integer X, the array-form of X is an array of its digits in left to right order.
 * For example, if X = 1231, then the array form is [1,2,3,1].
 * Given the array-form A of a non-negative integer X, return the array-form of the integer X+K.
 * @author jieai706
 * @date 2020-06-30
 */
public class P989 {

	public static void main(String[] args) {
		int[] A = {9,9,9,9,9,9,9,9,9,9};
		int K = 1;
//		int[] A = {1,2,3,4};
//		int K = 8766;
//		int[] A = {2,1,5};
//		int K = 806;
		System.out.println(addToArrayForm(A, K).size());
		addToArrayForm(A, K).forEach(item -> {
			System.out.print(item + ",");
		});
	}
	
	public static List<Integer> addToArrayForm(int[] A, int K) {
		String KS = String.valueOf(K);
		
		// 定义一个新数组，长度取A和K的最长的长度
		int BLen = A.length > KS.length() ? A.length : KS.length();
		int[] B = new int[BLen + 1];
		// 从后往前算，大于10则进位
		A = addArrayStr(B, A, 0, KS);
		List<Integer> result = new ArrayList<>();
		for (int i = 0;i < B.length;i ++) {
			if (i == 0 && B[i] == 0) 
				continue;
			result.add(B[i]);
		}
		return result;
    }

	private static int[] addArrayStr(int[] B, int[] A, int i, String KS) {
		if (i >= B.length - 1) 
			return B;
		if (i > A.length - 1) {
			// K比A长
			if (B[B.length - i - 1] + Integer.parseInt(String.valueOf(KS.charAt(KS.length() - i - 1))) >= 10) {			
				B[B.length - i - 1] = B[B.length - i - 1] + Integer.parseInt(String.valueOf(KS.charAt(KS.length() - i - 1))) - 10;
				B[B.length - i - 2] += 1;
			} else {
				B[B.length - i - 1] = B[B.length - i - 1] + Integer.parseInt(String.valueOf(KS.charAt(KS.length() - i - 1)));
			}
		} else if (i > KS.length() - 1) {
			// A比K长
			if (B[B.length - i - 1] + A[A.length - i - 1] >= 10) {			
				B[B.length - i - 1] = B[B.length - i - 1] + A[A.length - i - 1] - 10;
				B[B.length - i - 2] += 1;
			} else {
				B[B.length - i - 1] = B[B.length - i - 1] + A[A.length - i - 1];
			}
		} else {
			// 正常流程
			if (B[B.length - i - 1] + A[A.length - i - 1] + Integer.parseInt(String.valueOf(KS.charAt(KS.length() - i - 1))) >= 10) {			
				B[B.length - i - 1] = B[B.length - i - 1] + A[A.length - i - 1] + Integer.parseInt(String.valueOf(KS.charAt(KS.length() - i - 1))) - 10;
				B[B.length - i - 2] += 1;
			} else {
				B[B.length - i - 1] = B[B.length - i - 1] + A[A.length - i - 1] + Integer.parseInt(String.valueOf(KS.charAt(KS.length() - i - 1)));
			}
		}
		i ++;
		return addArrayStr(B, A, i, KS);
	}
	
	// 方法2使用LinkedList
	public List<Integer> addToArrayForm2(int[] A, int K) {
        int len = A.length;
        int lastNum =K;
        LinkedList<Integer> ret= new LinkedList<>();

        int i = len-1;
        while(i >=0 || lastNum > 0){
            if(i >= 0){
                lastNum+=A[i];
            }
            ret.addFirst(lastNum%10);
            lastNum/=10;
            i--;
        }

        return ret;

    }
}
