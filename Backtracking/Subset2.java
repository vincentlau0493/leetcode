public class Subset2 {

	public List<List<Integer>> subsetsWithDup(int[] num) {

		Arrays.sort(num);
		List<List<Integer>> res = new ArrayList();
		backtracking(num, res, 0, new ArrayList<Integer>());
		return res;

	}

	public void backtracking(int[] num, List<List<Integer>> res, int idx, List<Integer> can) {

		List<Integer> copy = new ArrayList(can);
		res.add(copy);

		int pre = Integer.MAX_VALUE;
		for (int i=idx; i<num.length; i++) {

			if (pre == num[i]) continue;
			can.add(num[i]);
			backtracking(num, res, i+1, can);
			can.remove(can.size()-1);
			pre = num[i];
		}

	}

}