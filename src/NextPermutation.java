import java.util.Arrays;

public class NextPermutation {
    private int findRightLow(int[] src) {
		int low=-1;
		for(int i=1;i<src.length;i++) {
			if(src[i]>src[i-1]) {
				low=i-1;
			}
		}
		return low;
	}

	private  int findLeftLow(int[] src,int si) {
		int high=si+1;
		for(int i=si+1;i<src.length;i++) {
			if(src[i]<=src[high] && src[i]>src[si]) {
				high=i;
			}
		}
		return high;
	}

	private void swap(int[] src,int fi,int ei) {
		int temp=src[fi];
		src[fi]=src[ei];
		src[ei]=temp;
	}

	private void reverse(int[] src,int si) {
		int j=src.length-1;
		for(int i=si;i<j;i++,j--) {
			swap(src, i, j);
		}
	}
	public void nextPermutation(int[] src) {
		if(src==null || src.length==0) {
			return;
		}

		int fi=findRightLow(src);
		if(fi==-1) {
			Arrays.sort(src);
	    	return;
		}
		int ei=findLeftLow(src,fi);
		swap(src,fi,ei);
		reverse(src,fi+1);
	}

}
