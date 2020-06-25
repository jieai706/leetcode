package leetcode.array;

public class P867 {

	// 二维数组行列转换
	public static void main(String[] args) {
//		int[][] A = {{1,2,3},{4,5,6},{7,8,9}};
		int[][] A = {{1,2,3},{4,5,6}};
		int[][] B = transpose(A);
		System.out.println(B[1][0]);
	}
	
	public static int[][] transpose(int[][] A) {
		int rowLen = A.length;
        int colLen = A[0].length;
        int[][] B = new int[colLen][rowLen];
        for (int i = 0;i < rowLen;i ++) {
        	for (int j = 0;j < colLen;j ++) {
        		B[j][i] = A[i][j];
        	}
        }
		return B;
    }
}
