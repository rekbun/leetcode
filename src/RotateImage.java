/**
 * Created with IntelliJ IDEA.
 * User: rakeshkumar
 * Date: 10/23/13
 * Time: 5:24 PM
 * To change this template use File | Settings | File Templates.
 */
public class RotateImage {
	private void swapEl(int[][] img,int i,int j) {
		int temp=img[i][j];
		img[i][j]=img[j][i];
		img[j][i]=temp;
	}
	private void transpose(int[][] img) {
		for(int i=0;i<img.length;i++) {
			for(int j=i;j<img.length;j++) {
				swapEl(img,i,j);
			}
		}
	}
	private void swapCol(int[][]img,int r,int c1,int c2)  {
		int temp=img[r][c1];
		img[r][c1]=img[r][c2];
		img[r][c2]=temp;
	}
	private void swap(int[][] img) {
		int i=0;
		int j=img.length-1;
		while(i<j) {
			for(int ci=0;ci<img.length;ci++) {
				swapCol(img,ci,i,j);
			}
		}
	}
	public void rotate(int[][] img) {
		if(img==null || img.length==0) {
			return;
		}

		//calculate transpose
		transpose(img);
		swap(img);
	}
}
