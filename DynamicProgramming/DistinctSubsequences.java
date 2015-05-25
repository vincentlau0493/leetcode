public class DistinctSubsequences {


	public static int DP(String S, String T) {

		S = " " + S;
		T = " " + T;
		int[][] dp = new int[T.length()][S.length()];
		for (int i=0; i<T.length(); i++) {
			for (int j=0; j<S.length(); j++) {
				if (i<1) {
					dp[i][j] = 1;
					continue;
				}
				if (j<1) {
					dp[i][j] = 0;
					continue;
				}

				if (T.charAt(i) == S.charAt(j))
					dp[i][j] = dp[i][j-1] + dp[i-1][j-1];
				else
					dp[i][j] = dp[i][j-1];

			}
		}
		return dp[T.length()-1][S.length()-1];
	}

	public static int compressDP(String S, String T) {

		S = " " + S;
		T = " " + T;
		int match = 0;
		int[] dp = new int[S.length()];

		for (int i=0; i<T.length(); i++) {
			for (int j=0; j<S.length(); j++) {
				if (i<1) {
					dp[j] = 1;
					continue;
				}
				if (j<1) {
					match = dp[j];
					dp[j] = 0;
					continue;
				}
				int tmp = dp[j];

				if (T.charAt(i) == S.charAt(j))
					dp[j] = dp[j-1] + match;
				else
					dp[j] = dp[j-1];

				match = tmp;
			}
		}
		return dp[S.length()-1];		
	}

	public static int backtracking(String S, String T, int count) {

		if (T.length() == 0) {
			return ++count;
		}

		if (S.length() == 0) {
			return count;
		}

		int notMatch = backtracking(S.substring(1), T, count);
		int match = S.charAt(0) == T.charAt(0) ? backtracking(S.substring(1), T.substring(1), count) : 0;
		return notMatch + match;


	}


}
