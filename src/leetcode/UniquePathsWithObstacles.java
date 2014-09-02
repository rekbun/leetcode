package leetcode;

/**
 * Created with IntelliJ IDEA.
 * User: rakeshkumar
 * Date: 10/26/13
 * Time: 2:33 PM
 * To change this template use File | Settings | File Templates.
 */
public class UniquePathsWithObstacles {
	public int uniquePathsWithObstacles(int[][] obstaclesGrid) {
		if(obstaclesGrid==null || obstaclesGrid.length==0) {
			return 0;
		}
		int[][] dp = new int[obstaclesGrid.length][obstaclesGrid[0].length];
	    for(int i=0;i<dp.length;i++) {
		    for(int j=0;j<dp[0].length;j++) {
			    dp[i][j]=-1;
		    }
	    }
		uniquePathsWithObstaclesUtil(0,0,obstaclesGrid, dp);
		return dp[0][0];
	}

	private int uniquePathsWithObstaclesUtil(int s, int e,int[][]grid, int[][] dp) {
		if(s==grid.length-1&& e==grid[0].length-1) {
			return 1;
		}
		if(s>=grid.length || e>=grid[0].length) {
			return 0;
		}

		if(grid[s][e]==1) {
			dp[s][e]=0;
			return 0;
		}
		if(dp[s][e]!=-1) {
			return dp[s][e];
		}


		int x=uniquePathsWithObstaclesUtil(s+1,e,grid,dp);
		int y=uniquePathsWithObstaclesUtil(s,e+1,grid,dp);
		dp[s][e]=x+y;
		return dp[s][e];
	}
}
