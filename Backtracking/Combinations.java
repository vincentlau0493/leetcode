public class Combinations {

	public List<List<Integer>> combine(int n, int k) {

		List<List<Integer>> res = new ArrayList();
		if (n == 0 || k == 0) return res;
		backtracking(n, k, 1, res, new ArrayList<Integer>());
		return res;

	}

	public void backtracking(int n, int k, int idx, List<List<Integer>> res, List<Integer> can) {

		if (k == can.size()) {
			List<Integer> copy = new ArrayList(can);
			res.add(copy);
			return;
		}

		for (int i=idx; i<=n; i++) {
			can.add(i);
			backtracking(n, k, i+1, res, can);
			can.remove(can.size()-1);
		}


	}


}