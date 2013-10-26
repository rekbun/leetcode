/**
 * Created with IntelliJ IDEA.
 * User: rakeshkumar
 * Date: 10/26/13
 * Time: 1:51 PM
 * To change this template use File | Settings | File Templates.
 */
public class UniquePaths {
	private int uniquePathsUtil(int s,int e,int m,int n,int[][] dp) {
		if(s==m-1&& e==n-1) {
			return 1;
		}
		if(s>=m || e>=n) {
			return 0;
		}

		if(dp[s][e]!=-1) {
			return dp[s][e];
		}
		int x=uniquePathsUtil(s+1,e,m,n,dp);
		int y=uniquePathsUtil(s,e+1,m,n,dp);
		dp[s][e]=x+y;
		return dp[s][e];
	}
	public int uniquePaths(int m,int n) {
		if(m<=1||n<=1) {
			return Math.max(m,n);
		}
		int[][] dp=new int[m][n];
		uniquePathsUtil(0,0,m,n,dp);
		return dp[m-1][n-1];


	}
}
