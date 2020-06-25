package leetcode.array;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class P120 {

	public static int minimumTotal(List<List<Integer>> triangle) {
        int row=triangle.size();    //行数
        if(row==0) return 0;
         
        int[][] res=new int[row][row];  //记录从第一行到每个点的最小值
        int minSum=Integer.MAX_VALUE;       //记录最小的sum
        List<Integer> list0=triangle.get(0);  //第1行只有一个数，
        if(list0.size()==0)
            return 0;
        if(row==1)
            return list0.get(0);
        res[0][0]=list0.get(0);
        for(int i=1;i<row;i++){
            List<Integer> list=triangle.get(i);
            for(int j=0;j<list.size();j++){
                if(j==0){
                    res[i][j]=res[i-1][j]+list.get(j);
                }else if(j==list.size()-1){
                    res[i][j]=res[i-1][j-1]+list.get(j);
                }else{
                    res[i][j]=Math.min(res[i-1][j-1],res[i-1][j])+list.get(j);
                }
                if(i==row-1){
                    if(minSum>res[i][j])
                        minSum=res[i][j];
                }
            }
        }
        return minSum;
    }
	
	public static void main(String[] args) {
		List<List<Integer>> triangle = new ArrayList<>();
		triangle = initParams(triangle);
		System.out.println(minimumTotal(triangle));
	}

	private static List<List<Integer>> initParams(List<List<Integer>> triangle) {
		// 初始化list
//		List<Integer> first = new ArrayList<Integer>(){{
//		    add(1);
//		}};
//		List<Integer> first = Stream.of(1).collect(Collectors.toList());
		// !!!三角形,5 和 4 2相邻,与3不相邻,状态转移方程:triangle[i][j] = min(triangle[i - 1][j - 1], triangle[i - 1][j])
		triangle = Stream.of(
				Stream.of(2).collect(Collectors.toList()),
				Stream.of(3,4).collect(Collectors.toList()),
				Stream.of(6,5,7).collect(Collectors.toList()),
				Stream.of(3,4,2,3).collect(Collectors.toList())
				).collect(Collectors.toList());
		return triangle;
	}
	
	// 时间复杂度0(n)
	public int minTotal(List<List<Integer>> triangle) {
        int row=triangle.size();    //行数
        if(row==0) return 0;
         
        int[] res=new int[row+1];       //倒着求，求最后一行到第一行最小和，这样就可以用o(n)空间了
         
        for(int i=row-1;i>=0;i--){
            List<Integer> list=triangle.get(i);
            for(int j=0;j<list.size();j++){
                res[j]=(Math.min(res[j+1],res[j])+list.get(j));//最后一行的最小值就是当前数
            }
        }
         
        return res[0];
    }
}
