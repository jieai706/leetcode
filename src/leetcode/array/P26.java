package leetcode.array;

/**
 * 
 * Remove Duplicates from Sorted Array
 * Given a sorted array nums, remove the duplicates in-place such that each element appear only once and return the new length.
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory
 * @author jieai706
 * @date 2020-07-16
 */
public class P26 {

	public static void main(String[] args) {
		int[] nums = {0};
		System.out.println(removeDuplicates(nums));
	}
	
	// 双指针
	public static int removeDuplicates(int[] nums) {
		// 去重后的指针
        int newIndex = 0;
        // 移动的指针
        int index = 0;
        while (index < nums.length) {
        	if (nums[newIndex] == nums [index]) {
        		nums[newIndex] = nums[index];
        		index ++;
        	} else {
        		newIndex ++;
        		nums[newIndex] = nums[index];
        	}
        }
		return newIndex + 1;
    }
}
