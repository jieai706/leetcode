package leetcode.string;

/**
 * 
 * Roman to Integer
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 * 1,5,10,50,100,500,1000
 * @author jieai706
 * @date 2020-07-13
 */
public class P13 {

	public static void main(String[] args) {
//		String s = "MCMXCIV";
//		String s = "MCMXCI";
		String s = "LVIII";
		System.out.println(romanToInt(s));
	}
	
	
	public static int romanToInt(String s) {
        int result = 0;
        for (int i = 0;i < s.length();) {
        	if ("M".equals(s.substring(i, i + 1))) {
        		result += 1000;
        		i ++;
        	} else if ("D".equals(s.substring(i, i + 1))) {
        		result += 500;
        		i ++;
        	} else if ("C".equals(s.substring(i, i + 1))) {
        		if (i < s.length() - 1 && "M".equals(s.substring(i + 1, i + 2))) {
        			result += 900;
        			i += 2;
        		} else if (i < s.length() - 1 && "D".equals(s.substring(i + 1, i + 2))) {
        			result += 400;
        			i += 2;
        		}else {        			
        			result += 100;
        			i ++;
        		}
        	} else if ("L".equals(s.substring(i, i + 1))) {
        		result += 50;
        		i ++;
        	} else if ("X".equals(s.substring(i, i + 1))) {
        		if (i < s.length() - 1 && "C".equals(s.substring(i + 1, i + 2))) {
        			result += 90;
        			i += 2;
        		} else if (i < s.length() - 1 && "L".equals(s.substring(i + 1, i + 2))) {
        			result += 40;
        			i += 2;
        		}else {        			
        			result += 10;
        			i ++;
        		}
        	} else if ("V".equals(s.substring(i, i + 1))) {
        		result += 5;
        		i ++;
        	} else if ("I".equals(s.substring(i, i + 1))) {
        		if (i < s.length() - 1 && "X".equals(s.substring(i + 1, i + 2))) {
        			result += 9;
        			i += 2;
        		} else if (i < s.length() - 1 && "V".equals(s.substring(i + 1, i + 2))) {
        			result += 4;
        			i += 2;
        		} else {        			
        			result += 1;
        			i ++;
        		}
        	}
        }
		return result;
    }
}
