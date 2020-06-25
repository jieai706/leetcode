package leetcode.array;

/**
 * 
 * Given an array of integers arr, a lucky integer is an integer which has a frequency in the array equal to its value.
 * Return a lucky integer in the array. If there are multiple lucky integers return the largest of them. If there is no lucky integer return -1.
 * @author jieai706
 * @date 2020-06-24
 */
public class P1394 {

	public static void main(String[] args) {
//		int[] arr = {1,2,2,3,3,3};
//		int[] arr = {2,2,2,3,3};
		int[] arr = {1,4,4,4,4,2};
		System.out.println(findLucky2(arr));
	}
	
	public static int findLucky(int[] arr) {		
        int len = arr.length;
        if (len == 1) {
        	return arr[0] == 1 ? 1: -1;
        }
        // 二维数组保存数字和出现的次数
        int[][] tmp = new int[len][len];
        for (int i = 0;i < len;i ++) {
        	if (i == 0) {
        		tmp[0][0] = arr[0];
        		tmp[0][1] = 1;
        		continue;
        	}
        	
        	int count = 1;
        	int firstIndex = 1;
        	for (int j =0;j < i;j ++) {
        		if (arr[i] > 0 && tmp[j][0] == arr[i]) {
        			if (count == 1) {
        				// 第一次出现的位置和次数
        				firstIndex = j;
        				count = tmp[firstIndex][1];
        			}
        			count ++;
        		}
        	}
        	if (count == 1) {
        		tmp[i][0] = arr[i];
        		tmp[i][1] = 1;
        	} else {
        		tmp[firstIndex][0] = arr[i];
        		tmp[firstIndex][1] = count;
        	}
        }
        // 匹配二维数组的数字和次数是否一致
        // tmp : [[1, 1, 0, 0, 0, 0], [2, 2, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0], [3, 3, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0]]
        // tmp : [[2, 3, 0, 0, 0], [0, 0, 0, 0, 0], [0, 0, 0, 0, 0], [3, 2, 0, 0, 0], [0, 0, 0, 0, 0]]        
        int result = -1;
        for (int i = 0;i < len;i ++) {
        	if (tmp[i][0] > 0 && tmp[i][0] == tmp[i][1]) {        		
        		if (tmp[i][0] > result)
        			result = tmp[i][0];
        	}
        }
		return result;
    }
	
	// 把数字arr[i]当做一维数组的下标，值当做次数
	public static int findLucky2(int[] arr) {

        int[] freq = new int[11];
        for (int i = 0; i < arr.length; i++) {
            freq[arr[i]]++;
        }
        for (int i = 10; i > 0; i--) {
            if (freq[i] == i) {
                return i;
            }
        }
        return -1;
        
    }
}
