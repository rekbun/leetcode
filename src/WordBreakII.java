import java.util.ArrayList;
import java.util.Set;

public class WordBreakII {
	public ArrayList<String> wordBreak(String s, Set<String> dict) {
		boolean[][] possible=new boolean[s.length()][s.length()];
		for(int i=0;i<s.length();i++) {
			for(int j=i;j>=0;j--) {
				if(dict.contains(s.substring(j,i+1))) {
					possible[j][i]=true;
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
		if(possible[0][s.length()-1]) {
			ArrayList<String> ret= wordBreakUtil(s,possible,dict,0);
			return ret;
		}
		return new ArrayList<String>();
	}

	private ArrayList<String> wordBreakUtil(String s,boolean[][] possible,Set<String> dict,int i) {
		ArrayList<String> ret= new ArrayList<String>();

		for(int index=i;index<s.length();index++) {
			if(dict.contains(s.substring(i,index+1))) {
				if((index+1)==s.length()) {
					ret.add(s.substring(i,index+1));
				}else {
					for(String str:wordBreakUtil(s,possible,dict,index+1)) {
						str=s.substring(i,index+1)+" "+str;
						ret.add(str);
					}
				}
			}
		}
		return ret;
	}
}
