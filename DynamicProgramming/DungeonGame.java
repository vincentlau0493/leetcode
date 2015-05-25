public class DungeonGame {

	public static int calculateMinimumHP(int[][] dungeon) {

		int n = dungeon.length;
		int m = dungeon[0].length;

		int[][] dp = new int[n][m];

		dp[n-1][m-1] = Math.max(-dungeon[n-1][m-1] + 1, 1);

		for (int i=n-1; i>=0; i--) {
			for (int j=m-1; j>=0; j--) {

				if (i == n-1 && j == m-1) continue;

				if (i == n-1) {
					dp[i][j] = Math.max(-dungeon[i][j] + dp[i][j+1], 1);
					continue;
				}
				if (j == m-1) {
					dp[i][j] = Math.max(-dungeon[i][j] + dp[i+1][j], 1);
					continue;
				}

				dp[i][j] = Math.max(1, Math.min(dp[i][j+1], dp[i+1][j]) - dungeon[i][j]);

			}
		}
		return dp[0][0];
	}



}