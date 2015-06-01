public class NQueens {

	public List<String[]> solveNQueens(int n) {

		List<String[]> res = new ArrayList();
		String[] can = new String[n];
		for (int i=0; i<n; i++) {
			StringBuilder sb = new StringBuilder();
			for (int j=0; j<n; j++) {
				sb.append(".");
			}
			can[i] = sb.toString();
		}

		backtracking(n, 0, res, can);
		return res;

	}

	public void backtracking(int n, int cur, List<String[]> res, String[] can) {

		if (n == cur) {

			String[] copy = can.clone();
			res.add(copy);
			return;

		}
		String tmp = can[cur];
		for (int i=0; i<n; i++) {
			if (isValid(can, cur, i)) {
				can[cur] = tmp.substring(0, i) + "Q" + tmp.substring(i+1);
				backtracking(n, cur + 1, res, can);
			}
		}
		can[cur] = tmp;
	}

	public boolean isValid(String[] can, int row, int col) {

		for (int i=0; i<row; i++) {

			int pos = can[i].indexOf("Q");
			if (pos == col || Math.abs(pos - col) == Math.abs(i - row)) return false;
		}
		return true;
	}

}



