/*
http://oj.leetcode.com/problems/single-number-ii/
 */
public class SingleNumberII {
	public int singleNumber(int[] A) {
		if (A.length == 0) {
			return 0;
		}
		int ones = 0;
		int twos = 0;
		for (int i = 0; i < A.length; i++) {
			int num = (ones ^ A[i]) & ~twos;
			twos = (ones & A[i]) | (twos & ~A[i]);
			ones = num;
		}

		return ones;
	}
}
