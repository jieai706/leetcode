package leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * 3Sum
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? 
 * Find all unique triplets in the array which gives the sum of zero.
 * The solution set must not contain duplicate triplets
 * @author jieai706
 * @date 2020-07-26
 */
public class P15 {

	public static void main(String[] args) {
		int[] nums = {-2,0,0,0,2,2,2,2};
//		int[] nums = {-1,0,1,2,-1,-4};
//		int[] nums = {0,0,0};
//		int[] nums = {-2,0,3,-1,4,0,3,4,1,1,1,-3,-5,4,0};
		List<List<Integer>> result = threeSum(nums);
		System.out.println(result.size());
	}
	
	// ע���ж��ظ��Ľ��
	public static List<List<Integer>> threeSum(int[] nums) {
		//������
		Arrays.sort(nums);
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		for (int i =0;i < nums.length - 1;i ++) {
			// ��ֹ�ظ�
			if (i > 0 && nums[i] == nums[i - 1])
				continue;
			int start = i + 1,end = nums.length - 1,threeNums = 0 - nums[i];
			// �����������ض��͵���Ԫ�أ�˫ָ���㷨
			while (start < end) {
				if (nums[start] + nums[end] == threeNums) {
					// �����ǰ�棬��Ȼ0��0��0��û�н��
					result.add(Arrays.asList(nums[i],nums[start],nums[end]));
					// ��ֹ�ظ�,��Ҫ��whileѭ������һ����һ��������,������if
					while (end > 0 && nums[end] == nums[end - 1]) {
						end --;
					}
					// ��ֹ�ظ�,����һ���ж�
					while (start < nums.length - 1 && nums[start] == nums[start + 1]) {
						start ++;
					}
					start ++;
					end --;
				} else if (nums[start] + nums[end] < threeNums) {
					start ++;
				} else {
					end --;
				}
			}
		}
		return result;
    }
}
