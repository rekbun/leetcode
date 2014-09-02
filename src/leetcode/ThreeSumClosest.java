package leetcode;/*
http://oj.leetcode.com/problems/3sum-closest/
 */
import java.util.Arrays;

public class ThreeSumClosest {
	public int threeSumClosest(int[] num, int target) {
		if (num.length<3) { // if less than three items then return 0
			return Integer.MAX_VALUE;
		}
		Arrays.sort(num);
		int res = num[0]+num[1]+num[2];
		for (int i=0; i<num.length-2; ++i) {
			if (i>0 && num[i]==num[i-1])  continue;
			for (int j=i+1; j<num.length-1; ++j) {
				if (j>i+1 && num[j]==num[j-1])  continue;
				// binary search for the third
				int start=j+1, end=num.length-1;
				while (start<=end) {
					int mid = (start+end)/2;
					int curRes = num[i] + num[j] + num[mid];
					int diff = curRes - target;
					if ( Math.abs(diff) < Math.abs(res - target) ) {
						res = curRes;
					}
					if (diff < 0) {
						start = mid+1;
					} else {
						end = mid-1;
					}
				}
			}
		}
		return res;
	}
}
