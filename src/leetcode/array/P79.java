package leetcode.array;

/**
 * 
 * DFS
 * @author jieai706
 * @date 2020-06-17
 */
public class P79 {

	static boolean result = false;
	static int[] dh = {0, 1, 0, -1};  //移动方向
    static int[] dw = {1, 0, -1, 0};
	public static void main(String[] args) {
		char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
		String word = "ABCCED";
		System.out.println(exist(board, word));
	}
	
	public static boolean exist(char[][] board, String word) {
        int vLength = board.length;
        int hLength = board[0].length;
        
		for (int i = 0;i < vLength;i ++) {
			for (int j = 0;j < hLength;j ++) {
//				if (word.charAt(0) == board[i][j]) {
//					boolean[][] isVisited = new boolean[vLength][hLength];
//					isVisited[i][j] = true;
//					// 遍历
//					DFS(board, isVisited, word, 1, i, j, vLength, hLength);
//					if(result==true){
//                        return true;
//                    }
//				}
				// B
				boolean[][] isVisited = new boolean[vLength][hLength];
				if (isThisWay(board, word, i, j, 0, isVisited, vLength, hLength)) 
					return true;
			}
		}
		 
		return false;
    }

	private static boolean isThisWay(char[][] board, String word, int row, int col, int index, boolean[][] isVisited,
			int vLength, int hLength) {
		if (row < 0 || row >= vLength || col < 0 || col >= hLength
				|| isVisited[row][col] || word.charAt(index) != board[row][col])
			return false;
		
		if (index == word.length() - 1)
			return true;
		
		index ++;
		isVisited[row][col] = true;
		
		for (int i = 0; i < 4; i++)
            if (isThisWay(board, word, row + dh[i], col + dw[i], index, isVisited, vLength, hLength))
                return true;
        isVisited[row][col] = false;
		return false;
	}

	/**
	 * 
	 * 方法说明
	 * @param board
	 * @param isVisited 与board对应，记录是否被访问过
	 * @param word
	 * @param index 已经匹配上的长度
	 * @param row
	 * @param col void
	 * @author jieai706
	 * @date 2020-06-12
	 */
	private static void DFS(char[][] board, boolean[][] isVisited, String word, 
			int index, int row, int col, int vLength, int hLength) {
		if (index == word.length()) {
			result = true;
			return ;
		}
			
		// 注意不要越界
		if (row - 1 >= 0 && word.charAt(index) == board[row-1][col] && !isVisited[row-1][col] && !result) {
			isVisited[row-1][col] = true;
            DFS(board, isVisited, word, index+1, row-1, col, vLength, hLength);
            isVisited[row-1][col] = false;
		}
		
		if (row + 1 <= vLength -1 && word.charAt(index) == board[row+1][col] && !isVisited[row+1][col] && !result) {
			isVisited[row+1][col] = true;
            DFS(board, isVisited, word, index+1, row+1, col, vLength, hLength);
            isVisited[row+1][col] = false;
		}
		
		if (col -1 >= 0 && word.charAt(index) == board[row][col-1] && !isVisited[row][col-1] && !result) {
			isVisited[row][col-1] = true;
            DFS(board, isVisited, word, index+1, row, col-1, vLength, hLength);
            isVisited[row][col-1] = false;
		}
		
		if (col + 1 <= hLength -1 && word.charAt(index) == board[row][col+1] && !isVisited[row][col+1] && !result) {
			isVisited[row][col+1] = true;
            DFS(board, isVisited, word, index+1, row, col+1, vLength, hLength);
            isVisited[row][col+1] = false;
		}
	}
}
