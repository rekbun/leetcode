/*
http://oj.leetcode.com/problems/4sum/
 */
import java.util.ArrayList;
import java.util.Arrays;

public class FourSum {
	public ArrayList<ArrayList<Integer>> threeSum(int[] num, int target) {
		ArrayList<ArrayList<Integer>> resultList = new ArrayList<ArrayList<Integer>>();

		for (int i = 0; i < num.length - 2; i++) {
			if (i > 0 && num[i] == num[i - 1]) continue;
			int j = i + 1;
			int k = num.length - 1;
			while (j < k) {
				int three_sum = num[i] + num[j] + num[k];
				if (three_sum > target) {
					k--;
				} else if (three_sum < target) {
					j++;
				} else {
					Integer[] tmp = { num[i], num[j], num[k] };
					boolean exist = false;
					for (ArrayList<Integer> triplet : resultList) {
						if (triplet.get(0) == num[i] &&
								triplet.get(1) == num[j] &&
								triplet.get(2) == num[k]) {
							exist = true;
							break;
						}
					}
					if (!exist) {
						resultList.add(new ArrayList<Integer>(Arrays.asList(tmp)));
					}
					j++;
					k--;
				}
			}
		}

		return resultList;
	}

	public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
		// Start typing your Java solution below
		// DO NOT write main() function
		Arrays.sort(num);
		ArrayList<ArrayList<Integer>> sum_result = new ArrayList<ArrayList<Integer>>();
		for (int a = 0; a < num.length - 3; a++) {
			if (a > 0 && num[a] == num[a - 1]) continue;
			int rest = target - num[a];
			int[] tmp_num_ary = Arrays.copyOfRange(num, a + 1, num.length);
			ArrayList<ArrayList<Integer>> three_sum_result = threeSum(
					tmp_num_ary, rest);
			for (ArrayList<Integer> arrayList : three_sum_result) {
				arrayList.add(0, num[a]);
			}
			sum_result.addAll(three_sum_result);
		}

		return sum_result;
	}




}
