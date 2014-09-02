package leetcode;

import java.util.ArrayList;
import java.util.HashMap;

public class FindSubstring {
    public ArrayList<Integer> findSubstring(String src,String[] lists) {
		if(src==null || src.length()==0) {
			return null;
		}
		HashMap<String,Integer> map= new HashMap<String, Integer>();
		for(int i=0;i<lists.length;i++) {
			if(map.containsKey(lists[i])) {
				map.put(lists[i],map.get(lists[i])+1);
			}else {
				map.put(lists[i],1);
			}
		}
		int len=lists[0].length();
		int tLen=len *lists.length;
		int cnt=0;
		ArrayList<Integer> ret= new ArrayList<Integer>();
		HashMap<String,Integer> mapCmp= new HashMap<String, Integer>();
		int si=0;
		for(int i=0;si<src.length()-tLen+1&& i<src.length();) {
			String word =src.substring(i,i+len);
			if(map.containsKey(word)) {
				if(mapCmp.containsKey(word)) {
					if(map.get(word)>mapCmp.get(word)) {
						i+=len;
						mapCmp.put(word,mapCmp.get(word)+1);
						cnt++;
					}else {
						i=si+1;
						si++;
						cnt=0;
						mapCmp.clear();
					}
				}else {
					mapCmp.put(word,1);
					i+=len;
					cnt++;
				}
			}else {
				si++;
				i=si;
				cnt=0;
				mapCmp.clear();
			}
			if(cnt==lists.length) {
				ret.add(si);
				si++;
				i=si;
				cnt=0;
				mapCmp.clear();
			}
		}
		return ret;
	}

}
