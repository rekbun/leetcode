/*
http://oj.leetcode.com/problems/roman-to-integer/
 */
import java.util.HashMap;

public class RomanToInteger {
	public int romanToInt(String s) {
		int[] numbers = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
		String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
		HashMap<String, Integer> hm = new HashMap<String, Integer>();
		for (int i = 0; i < numbers.length; i++) {
			hm.put(symbols[i], numbers[i]);
		}
		int res = 0;
		for (int i = 0; i < s.length(); i++) {
			if (i < s.length()-1 && hm.get(s.substring(i, i+2)) != null) {
				res = res + hm.get(s.substring(i, i+2));
				i++;
			} else {
				res = res + hm.get(s.substring(i, i+1));
			}
		}
		return res;
	}
}
