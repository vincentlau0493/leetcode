public class BuySellStock2 {

	public static int bruteForce(int[] prices) {
		int max = 0;
		for (int i=0; i<prices.length; i++) {
			max = Math.max(maxProfit(prices,0,i) + maxProfit(prices,i,prices.length-1), max);
		}
		return max;
	}

	public static int dp(int[] prices) {

		int n = prices.length;
		if (n == 0) return 0;

		int[] left = new int[n];
		int buy = prices[0];
		for (int i=1; i<n; i++) {
			if (prices[i] < buy)
				buy = prices[i];
			left[i] = Math.max(prices[i] - buy, left[i-1]);
		}
		int[] right = new int[n];
		int ans = left[n-1];
		int sell = prices[n-1];

		for (int i=n-2; i>=0; i--) {
			if (prices[i] > sell)
				sell = prices[i];
			right[i] = Math.max(right[i+1], sell - prices[i]);
			ans = Math.max(ans, left[i] + right[i]);
		}
		return ans;
	}



	//helper
	public static int maxProfit(int[] prices, int start, int end) {

		int ans = 0;
		int buy = prices[start];

		for (int i=start+1; i<=end; i++) {
			if (prices[i] < buy) 
				buy = prices[i];
			ans = Math.max(ans, prices[i] - buy);
		}
		return ans;
	}

}