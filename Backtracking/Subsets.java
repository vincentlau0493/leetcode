public class Subsets {

	public List<List<Integer>> subsets(int[] S) {

		Arrays.sort(S);
		List<List<Integer>> res = new ArrayList();
		backtracking(S, res, 0, new ArrayList<Integer>());
		return res;

	}

	public List<List<Integer>> bitManipulation(int[] S) {

		Arrays.sort(S);
		List<List<Integer>> res = new ArrayList();
		int bits = 1<<S.length;

		for (int bit=0; bit<bits; bit++) {

			List<Integer> can = new ArrayList();
			for (int i=0; i<S.length; i++) {
				if ((1 & (bit>>i)) == 1) can.add(S[i]);
			}
			res.add(can);
		}
		return res;
	}


	// helper
	public void backtracking(int[] S, List<List<Integer>> res, int idx, List<Integer> can) {

		List<Integer> copy = new ArrayList(can);
		res.add(copy);

		for (int i=idx; i<S.length; i++) {

			can.add(S[i]);
			backtracking(S, res, i+1, can);
			can.remove(can.size()-1);

		}

	}

}