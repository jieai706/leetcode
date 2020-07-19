package leetcode.array;

/**
 * 
 * Container With Most Water
 * @author jieai706
 * @date 2020-07-19
 */
public class P11 {

	public static void main(String[] args) {
		int[] height = {1,8,6,2,5,4,8,3,7};
		System.out.println(maxArea(height));
	}
	
	// 双层循环，能过
	// 建议使用双指针
	public static int maxArea(int[] height) {
		int result = 0;
		for (int i = 0;i < height.length;i ++) {
			for (int j = i + 1;j < height.length;j ++) {
				result = (j - i) * Math.min(height[i], height[j]) > result ? (j - i) * Math.min(height[i], height[j]) : result;
			}
		}
		return result;
	}
}
