package leetcode;

/**
 * Created with IntelliJ IDEA.
 * User: rakeshkumar
 * Date: 10/31/13
 * Time: 10:58 AM
 * To change this template use File | Settings | File Templates.
 */
public class SetZeroes {
	public void setZeroes(int[][] matrix) {
		if(matrix==null||matrix.length==0) {
			return;
		}

		int r=1;
		int c=1;
		for(int i=0;i<matrix[0].length;i++) {
			if(matrix[0][i]==0) {
				r=0;
				break;
			}
		}
		for(int i=0;i<matrix.length;i++) {
			if(matrix[i][0]==0) {
				c=0;
				break;
			}
		}

		for(int i=1;i<matrix.length;i++) {
			for(int j=1;j<matrix[0].length;j++) {
				if(matrix[i][j]==0) {
					matrix[0][j]=0;
					matrix[i][0]=0;
				}
			}
		}

		for(int i=1;i<matrix.length;i++) {
			if(matrix[i][0]==0) {
				for(int j=1;j<matrix[0].length;j++) {
					matrix[i][j]=0;
				}
			}
		}
		for(int j=1;j<matrix[0].length;j++) {
			if(matrix[0][j]==0) {
				for(int i=1;i<matrix.length;i++) {
					matrix[i][j]=0;
				}
			}
		}
		if(r==0) {
			for(int i=0;i<matrix[0].length;i++) {
				matrix[0][i]=0;
			}
		}
		if(c==0) {
			for(int i=0;i<matrix.length;i++) {
				matrix[i][0]=0;
			}
		}
	}
}
