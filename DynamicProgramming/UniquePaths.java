public class UniquePaths {


	public static int uniquePaths(int m, int n) {

		if (m == 0 || n == 0) return 0;

		int[][] dp = new int[m][n];

		for (int i=0; i<m; i++) {
			for (int j=0; j<n; j++) {
				if (i<1 || j<1) {
					dp[i][j] = 1;
					continue;
				}
				dp[i][j] = dp[i-1][j] + dp[i][j-1];
			}
		}
		return dp[m-1][n-1];
	}


}