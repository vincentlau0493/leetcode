public class ClimbingStairs {

	static Map<Integer, Integer> isVisited = new HashMap<Integer, Integer>();

	public static int dp(int n) {

		if (n < 2) return n;

		int dp[] = new int[n];
		dp[0] = 1;
		dp[1] = 2;

		for (int i=2; i<n; i++) {
			dp[i] = dp[i-1] + dp[i-2];
		}

		return dp[n-1];
	}

	public static int compressDP(int n) {

		if (n<2) return n;

		int a = 1;
		int b = 2;

		for (int i=2; i<n; i++) {

			int tmp = b;
			b += a;
			a = tmp;
		}
		return b;
	}

	public static int climbStairs(int n) {

		if (n <= 2) return n;
		if (isVisited.containsKey(n)) return isVisited.get(n);

		int res = climbStairs(n-1) + climbStairs(n-2);
		isVisited.put(n, res);
		return res;
	}

}