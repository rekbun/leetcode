/*
http://oj.leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
 */
public class BestTimeToBuyAndSellStocksII {
	public int maxProfit(int[] prices) {
		if(prices.length==0) {
			return 0;
		}
		int ret_max=0;
		for (int i=1;i<prices.length;i++) {
			if(prices[i]-prices[i-1]>0) {
				ret_max= ret_max+prices[i]-prices[i-1];
			}
		}
		return ret_max;
	}
}
