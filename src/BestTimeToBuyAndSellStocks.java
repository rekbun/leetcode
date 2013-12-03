/*
http://oj.leetcode.com/problems/best-time-to-buy-and-sell-stock/
 */
public class BestTimeToBuyAndSellStocks {
	public int maxProfit(int[] prices) {
		if(prices.length==0) {
			return 0;
		}

		int cur_low=prices[0];
		int max=0;

		for(int i=1;i<prices.length;i++) {
			if(prices[i]-cur_low<0) {
				cur_low=prices[i];
			}
			max=Math.max(prices[i]-cur_low,max);
		}
		return max;
	}
}
