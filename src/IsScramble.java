/*
http://oj.leetcode.com/problems/scramble-string/
 */
public class IsScramble {
	public boolean isScramble(String src,String dest) {
		int[][][] dp=new int[src.length()][src.length()][src.length()+1];
		for(int i=0;i<dp.length;i++) {
			for(int j=0;j<dp.length;j++) {
				for(int k=0;k<=dp.length;k++) {
					dp[i][j][k]=-1;
				}
			}
		}
		boolean ret= isScrambleUtil(src,dest,0,0,dp);
		return ret;
	}
	public boolean isScrambleUtil(String src,String dest,int s,int e,int [][][] dp) {
		if(dp[s][e][src.length()]!=-1) {
			return dp[s][e][src.length()]==1? true:false;
		}
		if(src.isEmpty() && dest.isEmpty()) {
			return true;
		}
		if(src.isEmpty() || dest.isEmpty()) {
			return false;
		}
		if(src.length()==1 && src.charAt(0)==dest.charAt(0)) {
			return true;
		}

		if(src.length()==2 && src.charAt(1)==dest.charAt(0) && src.charAt(0)==dest.charAt(1)) {
			return true;
		}

		for(int i=1;i<src.length();i++) {
			if(isScrambleUtil(src.substring(0,i), dest.substring(0,i),s,e,dp) && isScrambleUtil(src.substring(i,src.length()), dest.substring(i,dest.length()),s+i,e+i,dp)) {
				dp[s][e][src.length()]=1;
				return true;
			}

			if(isScrambleUtil(src.substring(0,i), dest.substring(dest.length()-i,dest.length()),s,e+dest.length()-i,dp) && isScrambleUtil(src.substring(i,src.length()), dest.substring(0,dest.length()-i),s+i,e,dp)) {
				dp[s][e][src.length()]=1;
				return true;
			}
		}
		dp[s][e][src.length()]=0;

		return false;
	}
}
