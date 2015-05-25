public class UniquePaths2 {


	public static int uniquePathsWithObstacles(int[][] obstacleGrid) {

		int n = obstacleGrid.length;
		if (n == 0) return 0;
		int m = obstacleGrid[0].length;

		obstacleGrid[0][0] = obstacleGrid[0][0] == 1 ? 0 : 1;

		for (int i=1; i<n; i++) {
			obstacleGrid[i][0] = obstacleGrid[i][0] == 1 ? 0 : obstacleGrid[i-1][0];
		}

		for (int j=1; j<m; j++) {
			obstacleGrid[0][j] = obstacleGrid[0][j] == 1 ? 0 : obstacleGrid[0][j-1];
		}

		for (int i=1; i<n; i++) {
			for (int j=1; j<m; j++) {
				if (obstacleGrid[i][j] == 1) {
					obstacleGrid[i][j] = 0;
					continue;
				}
				obstacleGrid[i][j] = obstacleGrid[i-1][j] + obstacleGrid[i][j-1];
			}
		}
		return obstacleGrid[n-1][m-1];
	}

	public static int oneDimension(int[][] obstacleGrid) {

		int width = obstacleGrid[0].length;
		int[] dp = new int[width];
		dp[0] = 1;

		for (int i=0; i<obstacleGrid.length; i++) {
			for (int j=0; j<width; j++) {

				if (obstacleGrid[i][j] == 1)
					dp[j] = 0;
				else if (j > 0) {
					dp[j] += dp[j-1];
				}
			}
		}

		return dp[width-1];

	}

}