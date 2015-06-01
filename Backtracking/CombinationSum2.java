public class CombinationSum2 {

	public List<List<Integer>> combinationSum2(int[] candidates, int target) {

		Arrays.sort(candidates);
		List<List<Integer>> res = new ArrayList();
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

		int pre = Integer.MAX_VALUE;
		for (int i=idx; i<num.length; i++) {
			if (pre == num[i]) continue;

			can.add(num[i]);
			backtracking(num, target-num[i], i+1, res, can);
			can.remove(can.size()-1);

			pre = num[i];
		}


	}

}