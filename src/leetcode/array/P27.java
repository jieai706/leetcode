package leetcode.array;

/**
 * 
 * Given an array nums and a value val, remove all instances of that value in-place and return the new length.
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 * @author jieai706
 * @date 2020-06-30
 */
public class P27 {

	public static void main(String[] args) {
//		int[] nums = {0,1,2,2,3,0,4,2};
		int[] nums = {2,0,1,2};
		int val = 2;
		int c = removeElementNew(nums, val);
		System.out.println(c);
	}
	
	// 数组中删除操作一般都是双指针交换元素
	// 使用两个碰撞指针前后遍历数组就行了,一个指向要删除的节点，一个指向不需要删除的节点，交换彼此即可	
	private static int removeElementNew(int[] nums, int val) {
		int i = 0; // 记录不删除的节点,i最后的位置就是数组删除后的长度
		int j = 0; // 记录要删除的节点,j不能小于i
		int tmp;
		while (j < nums.length) {
			// i和j不相等时交换
			if (nums[i] != nums[j]) {
				tmp = nums[i];
				nums[i] = nums[j];
				nums[j] = tmp;
			}
			// i在要删除的节点停止
			if (nums[i] != val)
				i ++;
			if (j <= i)
				j ++;
			// j在不删除的节点停止
			if (nums[j] == val)
				j ++;			
		}
		return i;
	}

	// 单向遍历
	private static int removeElement(int[] nums, int val) {
		int len = nums.length;
		// 从前往后循环
		// 每次比较数组第一个数,相同的将下一个值赋值到当前值
		// 不相同指针加1
		operateArray(nums,val,len,0, 1);
		int count = 0;
		for (int i = 0;i < len;i ++) {
			if (nums[i] != val)
				count ++;				
		}
		return count;
	}

	// nums数组,val要删除的值,len长度,index指针下标,tmp连续重复个数
	private static int[] operateArray(int[] nums, int val, int len,int index, int tmp) {
		if (len == 0 || index + tmp == nums.length)
			return nums;
		if (nums[index] == val) {
			nums[index] = nums[index + tmp];
			nums[index + tmp] = val;
			tmp ++;
		} else {
			index ++;
			tmp = 1;
			len --;
		}
		return operateArray(nums,val,len,index,tmp);
	}

	// 需要改变数组的内容，该方法不行
	public static int removeElement2(int[] nums, int val) {
        int len = nums.length;
        for (int i = 0;i < nums.length;i ++) {
        	if (nums[i] == val) {
        		len --;
        	}
        }
		return len;
    }
}
