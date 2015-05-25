public class PalindromePartitioning2 {

	public static int minCut(String s) {

		int n = s.length();
		boolean[][] isPal = new boolean[n][n];
		int[] dp = new int[n+1];
		dp[n] = -1;

		for (int i=0; i<n; i++) {
			dp[n-i-1] = i;
			for (int j=0; j<=i; j++) {
				isPal[i][j] = true;
			}
		}

		for (int i=n-1; i>=0; i--) {
			for (int j=n-1; j>i; j--) {
				isPal[i][j] = s.charAt(i) == s.charAt(j) && isPal[i+1][j-1];
				if (isPal[i][j])
					dp[i] = Math.min(dp[i], dp[j+1] + 1);
			}
			dp[i] = Math.min(dp[i], dp[i+1] + 1);
		}
		return dp[0];
	}




}