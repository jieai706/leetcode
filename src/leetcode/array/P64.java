package leetcode.array;

/**
 * 
 * Minimum Path Sum
 * P200,P79
 * @author jieai706
 * @date 2020-07-20
 */
public class P64 {

	public static void main(String[] args) {
//		int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
//		int[][] grid = {{1,3,1}};
		int[][] grid = {{1,3,2,5},{1,5,1,1},{4,2,1,2}};
		System.out.println(minPathSum(grid));
	}
	
	// �½�һ����ά�����¼����λ����С�ĺ�
	public static int minPathSum(int[][] grid) {
        int[][] minPathSumGrid = new int[grid.length][grid[0].length];
        // ��ʼֵһ��
        minPathSumGrid[0][0] = grid[0][0];
        // ��һ�е�ֵ����grid��һ����ʼֵ���ۼ�
        for (int i = 1;i < grid[0].length;i ++) {
        	minPathSumGrid[0][i] = grid[0][i] + minPathSumGrid[0][i - 1];
        }
        // ��һ�е�ֵ����grid��һ����ʼֵ���ۼ�
        for (int i = 1;i < grid.length;i ++) {
        	minPathSumGrid[i][0] = grid[i][0] + minPathSumGrid[i - 1][0];
        }
        
        for (int i = 1;i < grid.length;i ++) {
        	for (int j = 1;j < grid[0].length;j ++) {
        		minPathSumGrid[i][j] = Math.min(minPathSumGrid[i - 1][j], minPathSumGrid[i][j - 1]) + grid[i][j];
        	}
        }
        
		return minPathSumGrid[minPathSumGrid.length - 1][minPathSumGrid[0].length - 1];
    }
}
