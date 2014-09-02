package leetcode;

/*
http://oj.leetcode.com/problems/single-number/
 */
public class SingleNumber {
	public int singleNumber(int[] A) {
		int el=0;
		for(int i=0;i<A.length;i++) {
			el=el^A[i];
		}

		return el;
	}
}
