package leetcode.string;

/**
 * 
 * Integer to Roman
 * I,V,X, L, C,  D  ,M.
 * 1,5,10,50,100,500,1000
 * @author jieai706
 * @date 2020-07-14
 */
public class P12 {

	public static void main(String[] args) {
		int num = 58;
		System.out.println(intToRoman(num));
	}
	
	public static String intToRoman(int num) {
        StringBuffer result = new StringBuffer();
        int firstNumber = num % 10;
        int secondNumber = ((num - firstNumber) % 100)/10;
        int thirdNumber = ((num - firstNumber - secondNumber * 10) % 1000)/100;
        int forthNumber = ((num - firstNumber - secondNumber * 10 - thirdNumber * 100) % 10000)/1000;
        if (forthNumber < 4) {
        	while (forthNumber > 0) {
        		result.append("M");
        		forthNumber --;
        	}
        }
        
        if (thirdNumber == 9) {
        	result.append("CM");
        } else if (thirdNumber < 9 && thirdNumber > 5) {     
        	result.append("D");
    		while (thirdNumber > 5) {
    			result.append("C");
        		thirdNumber --;
        	}
        } else if (thirdNumber == 5) {
        	result.append("D");
        } else if (thirdNumber == 4) {
        	result.append("CD");
        } else if (thirdNumber < 4) {
        	while (thirdNumber > 0) {
        		result.append("C");
        		thirdNumber --;
        	}
        }
        
        if (secondNumber == 9) {
        	result.append("XC");
        } else if (secondNumber < 9 && secondNumber > 5) {
        	result.append("L");
        	while (secondNumber > 5) {
        		result.append("X");
            	secondNumber --;
        	}
        } else if (secondNumber == 5) {
        	result.append("L");
        } else if (secondNumber == 4) {
        	result.append("XL");
        } else if (secondNumber < 4) {
        	while (secondNumber > 0) {
        		result.append("X");
        		secondNumber --;
        	}
        }
        
        if (firstNumber == 9) {
        	result.append("IX");
        } else if (firstNumber < 9 && firstNumber > 5) {
        	result.append("V");
        	while (firstNumber > 5) {
        		result.append("I");
        		firstNumber --;
        	}
        } else if (firstNumber == 5) {
        	result.append("V");
        } else if (firstNumber == 4) {
        	result.append("IV");
        } else if (firstNumber < 4) {
        	while (firstNumber > 0) {
        		result.append("I");
        		firstNumber --;
        	}
        }
		return result.toString();
    }
}
