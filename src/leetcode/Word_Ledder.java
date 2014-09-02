package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/*
http://oj.leetcode.com/problems/word-ladder/
 */
public class Word_Ledder {
	HashMap<String,Integer> map;
	public int ladderLength(String start, String end, HashSet<String> dict) {
		map=new HashMap<String,Integer>();
		map.put(start,Integer.MAX_VALUE);
		return ladderLengthUtil(start,end,dict);
	}

	int ladderLengthUtil(String start,String end,HashSet<String> dict) {
		if(start.equals(end)) {
			return 0;
		}

		Queue<String> q=new LinkedList<String>();
		HashSet<String> set=new HashSet<String>();
		q.add(start);
		set.add(start);
		int lev1=1;
		int lev2=0;
		int min=0;
		while(!q.isEmpty()) {
			start=q.remove();
			lev1--;
			for(int i=0;i<start.length();i++) {
				for(int j=0;j<26;j++) {
					char[] myNameChars = start.toCharArray();
					myNameChars[i] = (char)('a'+j);
					String newStart = String.valueOf(myNameChars);
					if(newStart.equals(end)) {
						return min+2;
					}

					if(dict.contains(newStart)&&!set.contains(newStart)) {
						q.add(newStart);
						set.add(newStart);
						lev2++;
					}
				}
			}

			if(lev1==0) {
				lev1=lev2;
				lev2=0;
				min++;
			}
		}
		return 0;
	}
}
