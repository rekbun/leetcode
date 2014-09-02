package leetcode;

import java.util.HashMap;
import java.util.Stack;

public class ValidParentheses {
	public boolean isValid(String s) {

		HashMap<Character, Character> map = new HashMap<Character, Character>();
		map.put('[', ']');
		map.put(']', '[');
		map.put('(', ')');
		map.put(')', '(');
		map.put('{', '}');
		map.put('}', '{');

		Stack<Character> stack = new Stack<Character>();
		for(int i = 0; i < s.length(); i++) {
			if(!stack.isEmpty() && map.get(stack.peek()) == s.charAt(i))
				stack.pop();
			else
				stack.add(s.charAt(i));
		}

		if(stack.isEmpty())
			return true;
		else
			return false;
	}
}
