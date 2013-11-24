public class MergeTwoSortedArraysIntoOne {
	public void merge(int[] A, int m, int[] B, int n) {
		int e = m+n-1;
		int ae = m - 1;
		int be = n - 1;
		while (e >= 0) {
			if (ae >= 0 && be >= 0) {
				A[e--] = A[ae] > B[be] ? A[ae--] : B[be--];
			}else{
				A[e--]=be>=0?B[be--]:A[ae--];
			}
		}
	}
}
