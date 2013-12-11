/*
http://oj.leetcode.com/problems/candy/
 */
public class Candy {
	public int candy(int[] ratings) {
		if (ratings.length <= 1) {
			return ratings.length;
		}
		int cnt = 0;
		int candies[] = new int[ratings.length];
		candies[0] = 1;
		int n = ratings.length;
		for (int i = 0; i < n; i++) candies[i] = 1;

		for (int i = 1; i < n; i++) if (ratings[i] > ratings[i - 1]) candies[i] = candies[i - 1] + 1;

		for (int i = n - 2; i >= 0; i--) {
			if (ratings[i] > ratings[i + 1] && candies[i] <= candies[i + 1]) candies[i] = candies[i + 1] + 1;
		}

		for (int i = 0; i < n; i++) {
			cnt += candies[i];
		}

		return cnt;
	}
}
