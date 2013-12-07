import java.util.HashMap;
/*
http://oj.leetcode.com/problems/longest-consecutive-sequence/
 */
public class LargestConsecutiveSequence {
	public int longestConsecutive(int[] num) {
		HashMap<Integer,Boolean> map=new HashMap<Integer,Boolean>();
		if(num.length==0) {
			return 0;
		}

		for(int i=0;i<num.length;i++) {
			map.put(num[i],false);
		}

		int max=0;
		for(int i:num) {
			if(!map.get(i)) {
				map.put(i,true);
				int len=1+findMaxLen(map,i-1,-1);
				len+=findMaxLen(map,i+1,1);
				max=Math.max(max,len);
			}
		}
		return max;
	}

	int findMaxLen(HashMap<Integer,Boolean> map,int num,int step) {
		int len=0;
		while(map.containsKey(num)) {
			map.put(num,true);
			len++;
			num+=step;
		}
		return len;
	}

}

