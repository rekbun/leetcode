import java.util.LinkedList;
import java.util.Queue;

/*
http://oj.leetcode.com/problems/valid-palindrome/
 */
public class IsPalindrome {
	public boolean isPalindrome(String s) {
		// Note: The Solution object is instantiated only once and is reused by each test case.
		if(s.length()==0) {
			return true;
		}
		s=s.toLowerCase();
		int i=0,e=s.length()-1;
		while(i<e) {
			if(!Character.isLetterOrDigit(s.charAt(i))) {
				i++;
				continue;
			}
			if(!Character.isLetterOrDigit(s.charAt(e))) {
				e--;
				continue;
			}

			if(s.charAt(i)==s.charAt(e)) {
				i++;
				e--;
			}else{
				return false;
			}
		}
		return true;
	}
}
