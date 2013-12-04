/*
http://oj.leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
 */
public class BestTimeToSellAndBuyStockiii {
	int maxProfit(int[] prices) {
		int f[] = new int[3];
		int g[] =new int[3];

		int n = prices.length - 1;
		for (int i = 0; i < n; ++i) {
			int diff = prices[i+1] - prices[i];
			int m = Math.min(i+1, 2);
			for (int j = m; j >= 1; --j) {
				f[j] = Math.max(f[j], g[j-1]) + diff;
				g[j] = Math.max(g[j], f[j]);
			}
		}
		return Math.max(g[1], g[2]);
	}
}
