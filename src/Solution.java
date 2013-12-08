import java.util.ArrayList;
import java.util.HashSet;

public class Solution {
	public static void main(String[] args) {
		WordLadderII sol=new WordLadderII();
		HashSet<String> set =new HashSet<String>();
		set.add("a");
		set.add("b");
		set.add("c");
		sol.findLadders("a","c",set);

	}

}
