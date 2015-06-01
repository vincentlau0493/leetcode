public class WordSearch {

	public static int[][] dir = {{0,1}, {0,-1}, {1,0}, {-1,0}};

	public static boolean exist(char[][] board, String word) {

		int n = board.length;
		if (n == 0) return false;
		int m = board[0].length;

		boolean[][] isVisited = new boolean[n][m];
		for (int i=0; i<n; i++) {
			for (int j=0; j<m; j++) {
				isVisited[i][j] = false;
			}
		}

		for (int i=0; i<n; i++) {
			for (int j=0; j<m; j++) {
				if (backtracking(board, isVisited, i, j, word, 0))
					return true;
			}
		}

		return false;
	}

	public static boolean backtracking(char[][] board, boolean[][] isVisited, int i, int j, String word, int idx) {

		if (idx == word.length()) return true;
		int n = board.length;
		int m = board[0].length;

		if (i<0 || i>=n || j<0 || j>=m || isVisited[i][j] || board[i][j] != word.charAt(idx)) return false;

		isVisited[i][j] = true;
		for (int d=0; d<dir.length; d++) {
			if (backtracking(board, isVisited, i + dir[d][0], j + dir[d][1], word, idx + 1))
				return true;
		}
		isVisited[i][j] = false;
		return false;
	}


}