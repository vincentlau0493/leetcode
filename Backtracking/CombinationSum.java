public class CombinationSum {


	public List<List<Integer>> combinationSum(int[] candidates, int target) {

		List<List<Integer>> res = new ArrayList();
		Arrays.sort(candidates);
		backtracking(candidates, target, 0, res, new ArrayList<Integer>());
		return res;

	}

	public void backtracking(int[] num, int target, int idx, List<List<Integer>> res, List<Integer> can) {

		if (target == 0) {
			List<Integer> copy = new ArrayList(can);
			res.add(copy);
			return;
		}

		if (target < 0) return;

		for (int i=idx; i<num.length; i++) {

			can.add(num[i]);
			backtracking(num, target-num[i], i, res, can);
			can.remove(can.size()-1);

		}

	}


}