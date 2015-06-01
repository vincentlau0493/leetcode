public class GenerateParentheses {

	public List<String> generateParenthesis(int n) {

		List<String> res = new ArrayList();
		if (n == 0) return res;
		backtracking(n, n, res, "");
		return res;

	}

	public void backtracking(int open, int close, List<String> res, String can) {

		if (open == 0 && close == 0) {
			res.add(can);
			return;
		}

		if (open > close) return;
		if (open != 0)
			backtracking(open-1, close, res, can + "(");
		if (close != 0)
		backtracking(open, close-1, res, can + ")");
	}



}