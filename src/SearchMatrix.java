/**
 * Created with IntelliJ IDEA.
 * User: rakeshkumar
 * Date: 10/26/13
 * Time: 9:57 PM
 * To change this template use File | Settings | File Templates.
 */
public class SearchMatrix {
	public boolean searchMatrix(int[][]grid,int k) {
		int r=0;
		int c=grid[0].length-1;
		while(r<grid.length&&c>=0) {
			if(grid[r][c]==k) {
				return true;
			}else if(grid[r][c]<k) {
				r++;
			}else {
				c--;
			}
		}
		return false;
	}
}
