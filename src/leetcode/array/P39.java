package leetcode.array;

import java.util.ArrayList;
import java.util.List;

public class P39 {

	public static void main(String[] args) {
		int[] candidates = {3,2,6,7};
		int target = 7;
		List<List<Integer>> list = combinationSum(candidates, target);
		System.out.println(list.size());
	}
	
	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> list = new ArrayList<>();
		calculate(candidates,target,result,list,0,0);
		return result;
    }

	private static void calculate(int[] candidates, int target, List<List<Integer>> result, List<Integer> list, int sum, int startIndex) {		
		if (sum < target) {
			// 还不够target继续加
			// 不从0开始，不然会有重复数据
			for (int i = startIndex;i < candidates.length;i ++) {
				list.add(candidates[i]);
				calculate(candidates, target, result, list, sum + candidates[i], i);
				list.remove(list.size() - 1);
			}
		} else if (sum == target) {
			// 用下面那个，不然最后的结果是空
//			result.add(list);
			result.add(new ArrayList<>(list));
		}
	}
}
