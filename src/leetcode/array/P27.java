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
	
	// ������ɾ������һ�㶼��˫ָ�뽻��Ԫ��
	// ʹ��������ײָ��ǰ��������������,һ��ָ��Ҫɾ���Ľڵ㣬һ��ָ����Ҫɾ���Ľڵ㣬�����˴˼���	
	private static int removeElementNew(int[] nums, int val) {
		int i = 0; // ��¼��ɾ���Ľڵ�,i����λ�þ�������ɾ����ĳ���
		int j = 0; // ��¼Ҫɾ���Ľڵ�,j����С��i
		int tmp;
		while (j < nums.length) {
			// i��j�����ʱ����
			if (nums[i] != nums[j]) {
				tmp = nums[i];
				nums[i] = nums[j];
				nums[j] = tmp;
			}
			// i��Ҫɾ���Ľڵ�ֹͣ
			if (nums[i] != val)
				i ++;
			if (j <= i)
				j ++;
			// j�ڲ�ɾ���Ľڵ�ֹͣ
			if (nums[j] == val)
				j ++;			
		}
		return i;
	}

	// �������
	private static int removeElement(int[] nums, int val) {
		int len = nums.length;
		// ��ǰ����ѭ��
		// ÿ�αȽ������һ����,��ͬ�Ľ���һ��ֵ��ֵ����ǰֵ
		// ����ָͬ���1
		operateArray(nums,val,len,0, 1);
		int count = 0;
		for (int i = 0;i < len;i ++) {
			if (nums[i] != val)
				count ++;				
		}
		return count;
	}

	// nums����,valҪɾ����ֵ,len����,indexָ���±�,tmp�����ظ�����
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

	// ��Ҫ�ı���������ݣ��÷�������
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
