package leetcode;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: rakeshkumar
 * Date: 10/24/13
 * Time: 9:36 AM
 * To change this template use File | Settings | File Templates.
 */
public class TotalNQueens {
	private boolean isValid(int row,int col,int[] list) {
		for(int i=0;i<row;i++) {
			if(list[i]==col) {
				return false;
			}
			if(Math.abs((list[i]-col))==Math.abs((i-row))) {
				return false;
			}
		}
		return true;
	}
	public int totalNQueensUtis(int row,int n,int[] list) {
		if(row==n) {
			  return 1;
		}

		int ret=0;
		for(int i=0;i<n;i++) {
			if(isValid(row,i,list)) {
				list[row]=i;
				ret+=totalNQueensUtis(row+1,n,list);
			}
		}
		return ret;
	}
	public int totalNQueens(int n) {
		if(n==0) {
			return 0;
		}
		int[] ret=new int[n];
		return totalNQueensUtis(0, n,ret);
	}
}
