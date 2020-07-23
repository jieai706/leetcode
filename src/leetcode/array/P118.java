package leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Pascal's Triangle
 * @author jieai706
 * @date 2020-07-23
 */
public class P118 {

	public static void main(String[] args) {
		int numRows = 5;
		List<List<Integer>> result = generate(numRows);
		System.out.println(result.size());
	}
	
	public static List<List<Integer>> generate(int numRows) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		for (int i = 0;i < numRows;i ++) {			
			List<Integer> list = new ArrayList<>();
			if (i == 0) {
				list.add(1);
			} else if (i == 1) {
				list.add(1);
				list.add(1);
			} else {				
				for (int j = 0;j < i + 1;j ++) {
					if (j == 0) {
						list.add(1);
					} else if (j == i) {
						list.add(1);
					} else {
						list.add(result.get(i - 1).get(j - 1) + result.get(i - 1).get(j));
					}
				}
			}
			result.add(list);
		}
		return result;
    }
}
