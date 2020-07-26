package leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Pascal's Triangle II
 * @author jieai706
 * @date 2020-07-23
 */
public class P119 {

	public static void main(String[] args) {
		int rowIndex = 3;
		// [1,3,3,1]
		List<Integer> result = getRow(rowIndex);
		System.out.println(result.size());
	}
	
	// C(n, m-1)
	public static List<Integer> getRow(int rowIndex) {
		List<Integer> result = new ArrayList<>();
		double s = 1;
		if (rowIndex == 0) {
			result.add(1);
		} else if (rowIndex == 1) {
			result.add(1);
			result.add(1);
		} else {
			result.add(1);
			for (int i = 1;i < rowIndex;i ++) {
				result.add((int)(s = (rowIndex - i + 1) * s / i));
			}
			result.add(1);
		}
		return result;
    }
}
