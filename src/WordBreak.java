/*
http://oj.leetcode.com/problems/word-break/
 */
import java.util.Set;

public class WordBreak {
	public boolean wordBreak(String s, Set<String> dict) {
		boolean[][] possible=new boolean[s.length()][s.length()];
		for(int i=0;i<s.length();i++) {
			for(int j=i;j>=0;j--) {
				if(dict.contains(s.substring(j,i+1))) {
					if(j>0) {
						possible[0][i]=possible[0][j-1];
					}else {
						possible[0][i]=true;
					}
				}
				if(possible[0][i]) {
					break;
				}
			}
		}
		return possible[0][s.length()-1];
	}
}
