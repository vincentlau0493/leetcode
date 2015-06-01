public class SudokuSolver {

	Set<Character>[] rowMap;
	Set<Character>[] colMap;
	Set<Character>[] cubeMap;


	public void solveSudoku(char[][] board) {

		int n = board.length;
		rowMap = new Set[n];
		colMap = new Set[n];
		cubeMap = new Set[n];
		for (int i=0; i<n; i++) {
			for (int j=0; j<n; j++) {
				rowMap[j] = rowMap[j] == null ? new HashSet() : rowMap[j];
				colMap[j] = colMap[j] == null ? new HashSet() : colMap[j];
				cubeMap[j] = cubeMap[j] == null ? new HashSet() : cubeMap[j];
				if (board[i][j] == '.') continue;

				rowMap[i].add(board[i][j]);
				colMap[j].add(board[i][j]);
				cubeMap[i/3*3+j/3].add(board[i][j]);
			}
		}

		backtracking(board, 0, 0);
	}

	public boolean backtracking(char[][] board, int curRow, int curCol) {

		int n = board.length;
		if (curCol == n) return backtracking(board, curRow + 1, 0);
		if (curRow == n) return true;

		if (board[curRow][curCol] != '.') return backtracking(board, curRow, curCol + 1);

		for (char c='1'; c<='9'; c++) {
			if (isValid(curRow, curCol, c)) {
				board[curRow][curCol] = c;
				rowMap[curRow].add(c);
				colMap[curCol].add(c);
				cubeMap[curRow/3*3+curCol/3].add(c);				
				if (backtracking(board, curRow, curCol + 1))
					return true;
				board[curRow][curCol] = '.';
				rowMap[curRow].remove(c);
				colMap[curCol].remove(c);
				cubeMap[curRow/3*3+curCol/3].remove(c);					
			}
		}
		return false;
	}

	public boolean isValid(int curRow, int curCol, char c) {

		if (rowMap[curRow].contains(c) || colMap[curCol].contains(c) || cubeMap[curRow/3*3+curCol/3].contains(c))
			return false;
		return true;


	}

}