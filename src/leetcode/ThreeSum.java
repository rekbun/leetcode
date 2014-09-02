package leetcode;/*
http://oj.leetcode.com/problems/3sum/
 */
import java.util.ArrayList;
import java.util.Arrays;

public class ThreeSum {
	public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
		// Start typing your Java solution below
		// DO NOT write main() function
		Arrays.sort(num);
		ArrayList<ArrayList<Integer>> triplet = new ArrayList<ArrayList<Integer>>();
		if (num.length==0 || num[num.length-1]<0) return triplet;
		int size = num.length;
		int chkk = num[0]-1;
		int chki = chkk;
		for (int k=1;k<num.length;k++) {
			//if (chkk==num[k]) continue;
			//chkk=num[k];
			int ps = -num[k];
			int i=0;
			int j=size-1;
			while (i<k && k<j) {
				if (num[i]+num[j]<ps) {
					i++;
				} else if (num[i]+num[j]>ps) {
					j--;
				} else {
					if (chki<num[i] || chkk!=num[k]) {
						triplet.add(new ArrayList<Integer>(Arrays.asList(num[i], num[k], num[j])));
						chki=num[i];
						chkk=num[k];
					}
					i++;
					j--;
				}
			}
		}
		return triplet;
	}
}

