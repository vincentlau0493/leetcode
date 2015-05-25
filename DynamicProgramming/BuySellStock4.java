public class BuySellStock4 {

	public static int maxProfit(int k, int[] prices) {

		if (k > prices.length/2) return maxProfit(prices);

		int[][] local = new int[prices.length][k+1]; //the max profit if sell the stock at current day
		int[][] global = new int[prices.length][k+1]; //the max profit till current day

		for (int i=1; i<prices.length; i++) {
			int diff = prices[i] - prices[i-1];
			for (int j=1; j<=k; j++) {
				//for local, 3 case
				// 1. max profit of the last transaction + buy yesterday and sell today (diff)
				// 2. max profit of the last transaction + buy today and sell today (0)
				// 3. keep the last stock and sell today
				local[i][j] = Math.max(global[i-1][j-1] + Math.max(0, diff), local[i-1][j] + diff);
				global[i][j] = Math.max(global[i-1][j], local[i][j]);
			}
		}


		return global[prices.length-1][k];
	}

	public static int compressMaxProfit(int k, int[] prices) {

		if (k > prices.length/2) return maxProfit(prices);

		int[] local = new int[k+1]; //the max profit if sell the stock at current day
		int[] global = new int[k+1]; //the max profit till current day

		for (int i=1; i<prices.length; i++) {
			int diff = prices[i] - prices[i-1];
			for (int j=k; j>=1; j--) {
				//for local, 3 case
				// 1. max profit of the last transaction + buy yesterday and sell today (diff)
				// 2. max profit of the last transaction + buy today and sell today (0)
				// 3. keep the last stock and sell today
				local[j] = Math.max(global[j-1] + Math.max(0, diff), local[j] + diff);
				global[j] = Math.max(global[j], local[j]);
			}
		}


		return global[k];		

	}

	public static int maxProfit(int[] prices) {

		int res = 0;
		for (int i=1; i<prices.length; i++) {
			res += Math.max(0, prices[i] - prices[i-1]);
		}
		return res;
	}
}