package leetcode;/*
http://oj.leetcode.com/problems/letter-combinations-of-a-phone-number/
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LetterCombinationOfaPhoneBook {
	private static final Map<Integer, String> map = new HashMap<Integer, String>();
	static {
		map.put(2, "abc");
		map.put(3, "def");
		map.put(4, "ghi");
		map.put(5, "jkl");
		map.put(6, "mno");
		map.put(7, "pqrs");
		map.put(8, "tuv");
		map.put(9, "wxyz");
	}

	public ArrayList<String> letterCombinations(String digits) {
		ArrayList<String> result = new ArrayList<String>();
		if (digits == null || digits.isEmpty()) {
			result.add("");
			return result;
		}

		int n = digits.length();
		int[] sizes = new int[n]; // sizes of the combination of the chars preceding char index i
		int total = 1;
		for (int i = 0; i < n; ++i) {
			String val = getValue(digits.charAt(i));
			sizes[i] = total;
			total *= val.length();
		}
		for (int i = 0; i < total; ++i) {
			char[] temp = new char[n];
			for (int j = 0; j < n; ++j) {
				String val = getValue(digits.charAt(j));
				temp[j] = val.charAt((i / sizes[j]) % val.length());
			}
			result.add(new String(temp));
		}
		return result;
	}

	private String getValue(char c) {
		return map.get(c - '0');
	}
}
