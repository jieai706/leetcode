package leetcode.array;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class P120 {

	public static int minimumTotal(List<List<Integer>> triangle) {
        int row=triangle.size();    //����
        if(row==0) return 0;
         
        int[][] res=new int[row][row];  //��¼�ӵ�һ�е�ÿ�������Сֵ
        int minSum=Integer.MAX_VALUE;       //��¼��С��sum
        List<Integer> list0=triangle.get(0);  //��1��ֻ��һ������
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
		// ��ʼ��list
//		List<Integer> first = new ArrayList<Integer>(){{
//		    add(1);
//		}};
//		List<Integer> first = Stream.of(1).collect(Collectors.toList());
		// !!!������,5 �� 4 2����,��3������,״̬ת�Ʒ���:triangle[i][j] = min(triangle[i - 1][j - 1], triangle[i - 1][j])
		triangle = Stream.of(
				Stream.of(2).collect(Collectors.toList()),
				Stream.of(3,4).collect(Collectors.toList()),
				Stream.of(6,5,7).collect(Collectors.toList()),
				Stream.of(3,4,2,3).collect(Collectors.toList())
				).collect(Collectors.toList());
		return triangle;
	}
	
	// ʱ�临�Ӷ�0(n)
	public int minTotal(List<List<Integer>> triangle) {
        int row=triangle.size();    //����
        if(row==0) return 0;
         
        int[] res=new int[row+1];       //�����������һ�е���һ����С�ͣ������Ϳ�����o(n)�ռ���
         
        for(int i=row-1;i>=0;i--){
            List<Integer> list=triangle.get(i);
            for(int j=0;j<list.size();j++){
                res[j]=(Math.min(res[j+1],res[j])+list.get(j));//���һ�е���Сֵ���ǵ�ǰ��
            }
        }
         
        return res[0];
    }
}
