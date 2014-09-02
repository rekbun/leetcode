package leetcode;

/*
 http://oj.leetcode.com/problems/distinct-subsequences/
 */
public class DistinctSubsequences {
	public int numDistinct(String S, String T) {
		if(S.length()>=0 && T.length()==0) {
			return 1;
		}
		if(S.length()==0) {
			return 0;
		}
		int[][] dp =new int[S.length()+1][T.length()+1];
		for(int i=0;i<dp.length;i++) {
			for(int j=0;j<dp[0].length;j++) {
				dp[i][j]=-1;
			}
		}
		numDistinctUtil(S,T,dp,0,0);
		return dp[0][0];
	}

	private int numDistinctUtil(String s, String t, int[][] dp, int r, int c) {
		if(s.length()-r<t.length()-c) {
			dp[r][c]=0;
			return 0;
		}

		if(c==t.length()) {
			dp[r][c]=1;
			return 1;
		}
		if(r>=s.length()||c>t.length()) {
			return 0;
		}

		if(dp[r][c]!=-1) {
			return dp[r][c];
		}
		dp[r][c]=0;
		if(s.charAt(r)==t.charAt(c)) {
			dp[r][c]+=numDistinctUtil(s, t, dp, r+1, c+1);
		}
		int x=0;
		while(r+1+x<s.length()&&(s.charAt(r+1+x)!=t.charAt(c))) {
			x++;
		}
		dp[r][c]+=numDistinctUtil(s, t, dp, r+1+x, c);
		return dp[r][c];
	}
}
