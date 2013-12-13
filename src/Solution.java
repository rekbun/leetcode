import java.util.ArrayList;
import java.util.HashSet;

public class Solution {
	public static void main(String[] args) {
		WordBreakII sol=new WordBreakII();
		HashSet<String> set=new HashSet<String>();
		set.add("cat");
		set.add("cats");
		set.add("and");
		set.add("sand");
		set.add("dog");
		sol.wordBreak("catsanddog",set);
	}
}
