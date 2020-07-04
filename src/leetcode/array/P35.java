package leetcode.array;

/**
 * Search Insert Position
 * Given a sorted array and a target value, return the index if the target is found. 
 * If not, return the index where it would be if it were inserted in order.You may assume no duplicates in the array.
 * @author jieai706
 * @date 2020-07-04
 */
public class P35 {

	public static void main(String[] args) {
		int[] nums = {1,3,5,6};
		int target = 7;
		int result = searchInsert(nums, target);
		System.out.println(result);
	}
	
	public static int searchInsert(int[] nums, int target) {
		int index = 0;
        for (int i = 0;i < nums.length;i ++) {
        	if (nums[i] >= target) {        		
        		index = i;break;
        	}
        	index ++;
        }
		return index;
    }
}
