package leetcode.string;

import java.util.Stack;

public class P20 {

	public static void main(String[] args) {
		String s = "()[]{}";
		System.out.println(isValid(s));
		System.out.println(isValid2(s));
	}	

	public static boolean isValid(String s) {
        Stack<String> stack = new Stack<>();
        for (int i = 0;i < s.length();i ++) {
        	// 如果栈内没有元素，则需要进栈
        	if (stack.size() == 0) {
        		stack.push(String.valueOf(s.charAt(i)));
        		continue;
        	}
        	// 栈顶元素与当前元素是否匹配，匹配的话出栈，不匹配则进栈
        	if ((stack.peek().equals("(") && String.valueOf(s.charAt(i)).equals(")"))
        			|| (stack.peek().equals("[") && String.valueOf(s.charAt(i)).equals("]"))
        					|| (stack.peek().equals("{") && String.valueOf(s.charAt(i)).equals("}"))) {
        				stack.pop();
        			} else {        				
        				stack.push(String.valueOf(s.charAt(i)));
        			}
        }
        if (stack.size() == 0)
        	return true;
		return false;
    }
	
	// 大神代码！！！
	private static boolean isValid2(String s) {
		Stack<Character> stack = new Stack<Character>();
		for (char c : s.toCharArray()) {
			if (c == '(')
				stack.push(')');
			else if (c == '{')
				stack.push('}');
			else if (c == '[')
				stack.push(']');
			else if (stack.isEmpty() || stack.pop() != c)
				return false;
		}
		return stack.isEmpty();
	}
}
