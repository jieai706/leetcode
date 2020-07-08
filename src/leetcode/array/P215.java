package leetcode.array;

/**
 * Kth Largest Element in an Array
 * Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.
 * @author jieai706
 * @date 2020-07-04
 */
public class P215 {

	public static void main(String[] args) {
		int[] nums = {3,2,1,5,6,4};
		int k = 6;
		int result = findKthLargest(nums, k);
		System.out.println(result);
	}
	
	public static int findKthLargest(int[] nums, int k) {
		if (nums.length == 1)
			return nums[0];
        // 新定义一个长度为k的数组,有序,降序
		int[] tmp = new int[k];
		for (int i = 0;i < k;i ++) {
			tmp = sortTmp(tmp, i, nums[i]);
		}
		// 处理k-nums.length的数据,如果比tmp中最小的数大则插入tmp中
		for (int i = k;i < nums.length;i ++) {			
			tmp = sortOther(tmp, nums[i]);
		}
		return tmp[k-1];
    }

	private static int[] sortOther(int[] kArray, int num) {
		// 记录插入的位置
		int tmp = kArray.length;
		// 与所有元素比较
		for (int i = 0;i < kArray.length;i ++) {
			if (num > kArray[i]) {
				tmp = i;
				break;
			}
		}
		if (tmp == kArray.length)
			return kArray;
		// tmp-kArray.length位置后移
		for (int j = kArray.length - 1;j > tmp;j --) {
			kArray[j] = kArray[j - 1];
		}
		kArray[tmp] = num;
		return kArray;
	}

	private static int[] sortTmp(int[] kArray, int t, int num) {
		// 记录插入的位置
		int tmp = t;
		// 与前t个元素比较
		for (int i = 0;i < t;i ++) {
			if (num > kArray[i]) {
				tmp = i;
				break;
			}
		}
		// tmp-t+1位置后移
		for (int j = t;j > tmp;j --) {
			kArray[j] = kArray[j - 1];
		}
		kArray[tmp] = num;
		return kArray;
	}
}
