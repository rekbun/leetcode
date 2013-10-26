/**
 * Created with IntelliJ IDEA.
 * User: rakeshkumar
 * Date: 10/26/13
 * Time: 4:07 PM
 * To change this template use File | Settings | File Templates.
 */
public class MinPathSum {

	private int minPathSumUtil(int[][] grid, int r, int c , int[][] dp) {
		if(r>=grid.length|| c>=grid[0].length) {
			return Integer.MAX_VALUE;
		}
		if(dp[r][c]!=Integer.MAX_VALUE) {
			return dp[r][c];
		}
		if(r==grid.length-1&& c==grid[0].length-1) {
			dp[r][c]=grid[r][c];
			return dp[r][c];
		}

		dp[r][c]=grid[r][c]+Math.min(minPathSumUtil(grid, r+1, c, dp),minPathSumUtil(grid, r, c+1, dp));
		return dp[r][c];
	}

	public int minPathSum(int[][] grid) {
		if(grid==null|| grid.length==0) {
			return 0;
		}
		int[][] dp= new int[grid.length][grid[0].length];
		for(int i=0;i<dp.length;i++) {
			for(int j=0;j<dp[0].length;j++) {
				dp[i][j]=Integer.MAX_VALUE;
			}
		}
		minPathSumUtil(grid,0,0,dp);
		return dp[0][0];
	}


}
