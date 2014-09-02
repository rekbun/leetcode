package leetcode;

/*
http://oj.leetcode.com/problems/longest-common-prefix/
 */
public class LongestCommonPrefix {
	public String longestCommonPrefix(String[] strs) {
		if (strs.length == 0)  return "";
		int index = 0;
		while (index < strs[0].length()) {
			char c = strs[0].charAt(index);
			for (int i=1; i<strs.length; ++i) {
				if (index >= strs[i].length() || strs[i].charAt(index) != c) {
					return strs[0].substring(0, index);
				}
			}
			index++;
		}
		return strs[0];
	}
}
