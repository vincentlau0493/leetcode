public class BuySellStock {


	public static int maxProfit(int[] prices) {

		int ans = 0;
		int cur = prices[0];

		for (int i=1; i<prices.length; i++) {

			if (prices[i] < cur) {
				cur = prices[i];
			}
			ans = Math.max(ans, prices[i] - cur);
		}
		return ans;
	}
}