public class NQueens2 {


	public int totalNQueens(int n) {

		int[] helper = new int[n];
		return backtracking(helper, 0, 0);



	}

	public int backtracking(int[] helper, int cur, int count) {

		int n = helper.length;
		if (n == cur) return ++count;

		for (int i=0; i<n; i++) {

			if (isValid(helper, cur, i)) {
				helper[cur] = i;
				count = backtracking(helper, cur + 1, count);
			}

		}
		return count;
	}

	public boolean isValid(int[] helper, int row, int col) {

		for (int i=0; i<row; i++) {

			int pos = helper[i];
			if (pos == col || Math.abs(pos - col) == Math.abs(i - row)) return false;
		}
		return true;
	}
}