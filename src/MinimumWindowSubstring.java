import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: rakeshkumar
 * Date: 10/31/13
 * Time: 11:55 AM
 * To change this template use File | Settings | File Templates.
 */
public class MinimumWindowSubstring {
	public String minWindow(String src,String key) {
		if(src==null||src.length()==0) {
			return src;
		}
		HashMap<Character,Integer> map = new HashMap<Character, Integer>();
		for(int i=0;i<key.length();i++) {
			if(map.containsKey(key.charAt(i))) {
				map.put(key.charAt(i),map.get(key.charAt(i))+1);
			}else {
				map.put(key.charAt(i),1);
			}
		}
		HashMap<Character,Integer> checker=new HashMap<Character, Integer>();
		int cnt=0;
		int s=-1;
		int e=-1;
		for(int i=0;i<src.length();i++) {
			if(map.containsKey(src.charAt(i))) {
				if(s==-1) {
					s=i;
				}
				if(checker.containsKey(src.charAt(i))) {
					if(checker.get(src.charAt(i))<map.get(src.charAt(i))) {
						cnt++;
					}
					checker.put(src.charAt(i),checker.get(src.charAt(i))+1);

					while(checker.get(src.charAt(s))>map.get(src.charAt(s))){
						checker.put(src.charAt(s),checker.get(src.charAt(s))-1);
						s++;
						while(!map.containsKey(src.charAt(s))) {
							s++;
						}
					}


				}else {
					checker.put(src.charAt(i),1);
					cnt++;
				}
			}
			if(cnt==key.length()) {
				e=i;
				break;
			}
		}
		if(e==-1) {
			return "";
		}
		String ans=src.substring(s,e+1);
		for(int i=e+1;i<src.length();i++) {
			if(map.containsKey(src.charAt(i))) {
				checker.put(src.charAt(i),checker.get(src.charAt(i))+1);
				while(checker.get(src.charAt(s))>map.get(src.charAt(s))){
					checker.put(src.charAt(s),checker.get(src.charAt(s))-1);
					s++;
					while(!map.containsKey(src.charAt(s))) {
						s++;
					}
				}
			}
			if(ans.length()>(i-s+1)) {
				ans=src.substring(s,i+1);
			}
		}
		return ans;
	}

}
