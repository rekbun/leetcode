/**
 * Created with IntelliJ IDEA.
 * User: rakeshkumar
 * Date: 10/27/13
 * Time: 12:21 PM
 * To change this template use File | Settings | File Templates.
 */
public class ClimbingStairs {
	public int climbingStairs(int s,int e,int[]dp) {
		if(s>e) {
			return 0;
		}
		if(s==e) {
			return 1;
		}

		if(dp[s]!=0) {
			return dp[s];
		}
		dp[s]+=climbingStairs(s+1,e,dp);
		dp[s]+=climbingStairs(s+2,e,dp);
		return dp[s];
	}

	public int climbStairs(int n) {
		if(n==0) {
			return 0;
		}
		int[] dp=new int[n+1];
		climbingStairs(0,n,dp);
		return dp[0];
	}
}
