package leetcode;

/**
 * Created with IntelliJ IDEA.
 * User: rakeshkumar
 * Date: 10/27/13
 * Time: 11:59 PM
 * To change this template use File | Settings | File Templates.
 */
public class EditDistance {
	private int minDistanceUtil(String w1,String w2,int s1,int s2,int[][] dp) {
		if(s1==w1.length() && s2==w2.length()) {
			dp[s1][s2]=0;
			return 0;
		}
		if(s1>w1.length()||s2>w2.length()) {
			return Integer.MAX_VALUE;
		}
		if(s1==w1.length()) {
			dp[s1][s2]=Math.min(dp[s1][s2],w2.length()-s2);
			return dp[s1][s2];
		}

		if(s2==w2.length()) {
			dp[s1][s2]=Math.min(dp[s1][s2],w1.length()-s1);
			return dp[s1][s2];
		}

		if(dp[s1][s2]!=Integer.MAX_VALUE) {
			return dp[s1][s2];
		}

		if(w1.charAt(s1)==w2.charAt(s2)) {
			dp[s1][s2]=minDistanceUtil(w1,w2,s1+1,s2+1,dp);
		}else {
			int y=Math.min(minDistanceUtil(w1,w2,s1+1,s2,dp),minDistanceUtil(w1,w2,s1,s2+1,dp));
			if(y!=Integer.MAX_VALUE) {
				dp[s1][s2]=y+1;
			}
			y=minDistanceUtil(w1,w2,s1+1,s2+1,dp);
			if(y!=Integer.MAX_VALUE) {
				dp[s1][s2]=Math.min(dp[s1][s2],y+1) ;
			}
		}

		return dp[s1][s2];
	}
	public int minDistance(String w1,String w2) {
		int[][] dp= new int[w1.length()+1][w2.length()+1];
		for(int i=0;i<=w1.length();i++) {
			for(int j=0;j<=w2.length();j++) {
				dp[i][j]=Integer.MAX_VALUE;
			}
		}
		minDistanceUtil(w1,w2,0,0,dp);
		return dp[0][0];
	}
}
