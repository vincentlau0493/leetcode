public class EditDistance {


	public static int minDistance(String word1, String word2) {

		word1 = " " + word1;
		word2 = " " + word2;

		int[][] dp = new int[word1.length()][word2.length()];
		dp[0][0] = 0;

		for (int i=0; i<word1.length(); i++) {
			for (int j=0; j<word2.length(); j++) {
				if (i==0 && j==0) continue;
				if (i<1) {
					dp[i][j] = j;
					continue;
				}
				if (j<1) {
					dp[i][j] = i;
					continue;
				}

				int delete = dp[i-1][j] + 1;
				int insert = dp[i][j-1] + 1;
				int replace = dp[i-1][j-1];
				if (word1.charAt(i) != word2.charAt(j)) {
					replace++;
				}
				int min = Math.min(delete, insert);
				dp[i][j] = Math.min(min, replace);

			}
		}

		return dp[word1.length()-1][word2.length()-1];
	}

	public static int compressDP(String word1, String word2) {

		word1 = " " + word1;
		word2 = " " + word2;
		int[] dp = new int[word2.length()];		
		int replace = 0;

		for (int i=0; i<word1.length(); i++) {
			for (int j=0; j<word2.length(); j++) {

				if (i<1) {
					dp[j] = j;
					continue;
				}
				if (j<1) {
					replace = dp[j];
					dp[j] = i;
					continue;
				}
				int tmp = dp[j];
				int insert = dp[j-1] + 1;
				int delete = dp[j] + 1;

				int min = Math.min(insert, delete);
				if (word1.charAt(i) != word2.charAt(j))
					replace++;
				dp[j] = Math.min(min, replace);
				replace = tmp;
			}
		}
		return dp[word2.length()-1];
	}

}


