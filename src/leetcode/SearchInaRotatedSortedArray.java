package leetcode;

import java.util.Arrays;

/*
 *  http://oj.leetcode.com/problems/search-in-rotated-sorted-array-ii/
 *
 * */
public class SearchInaRotatedSortedArray {
	public boolean search(int A[],int key) {
		int l = 0, r = A.length - 1;
		while (l <= r) {
			int m = l + (r - l)/2;
			if (A[m] == key) return true; //return m in Search in Rotated Array I
			if (A[l] < A[m]) { //left half is sorted
				if (A[l] <= key && key < A[m])
					r = m - 1;
				else
					l = m + 1;
			} else if (A[l] > A[m]) { //right half is sorted
				if (A[m] < key && key <= A[r])
					l = m + 1;
				else
					r = m - 1;
			} else l++;
		}
		return false;
	}
}
