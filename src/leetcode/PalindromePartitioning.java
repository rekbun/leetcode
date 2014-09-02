package leetcode;

import java.util.ArrayList;

public class PalindromePartitioning {
    public ArrayList<ArrayList<String>> partition(String s) {
		if(s==null || s.length()==0) {
			return null;
		}
		
		int[][] palin; 
		palin=findPalindrome(s);
		return findPartitons(s,palin,0);
		
	}

	private ArrayList<ArrayList<String>> findPartitons(String s, int[][] palin,int si) {
		if(si>=s.length()) {
			return new ArrayList<ArrayList<String>>();
		}
		ArrayList<ArrayList<String>> ret=new ArrayList<ArrayList<String>>();
		for(int len=1;len<=s.length();len++) {
			if(si+len<=s.length()&& palin[si][si+len-1]==1) {
				ArrayList<ArrayList<String>> temp=findPartitons(s,palin,si+len);
				if(temp!=null) {
					String str=s.substring(si,si+len);
					for(ArrayList<String> it:temp) {
						it.add(0,str);
					}
					if(temp.size()==0) {
						ArrayList<String> toAdd= new ArrayList<String>();
						toAdd.add(str);
						temp.add(toAdd);
					}
					ret.addAll(temp);
				}
			}
		}
		return ret;
	}

	private int[][] findPalindrome(String s) {
		int ret[][]=new int[s.length()][s.length()];
		for(int i=0;i<s.length();i++) {
			ret[i][i]=1;
		}
		for (int i=1;i<s.length();i++) {
			if(s.charAt(i)==s.charAt(i-1)) {
				ret[i-1][i]=1;
			}else {
				ret[i-1][i]=0;
			}
			
		}
		for(int len=3;len<=s.length();len++) {
			for(int i=0;i+len<s.length()+1;i++) {
				int j=i+len-1;
				if(s.charAt(i)==s.charAt(j)) {
					  ret[i][j]=ret[i+1][j-1];
				}else {
					  ret[i][j]=0;
				}
				
			}
		}
		return ret;
	}
}
