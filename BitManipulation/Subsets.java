public class Subsets {

	public List<List<Integer>> bitwise(int[] S) {

		List<List<Integer>> res = new ArrayList();
		int n = S.length;
		Arrays.sort(S);
		int range = 1<<n;
		List<Integer> can = null;
		for (int bit=0; bit<range; bit++) {
			can = new ArrayList();
			for (int i=0; i<n; i++) {
				if (((bit>>i)&1) == 1) can.add(S[i]);
			}
			res.add(can);
		}
		return res;
	}

	public void backtracking(int[] S, List<List<Integer>> res, List<Integer> can, int idx) {

		List<Integer> copy = new ArrayList(can);
		res.add(copy);

		for (int i=idx; i<S.length; i++) {
			can.add(S[i]);
			backtracking(S, res, can, i+1);
			can.remove(can.size()-1);
		}

	}

	public List<List<Integer>> iterative(int[] S) {

		List<List<Integer>> res = new ArrayList();
		Arrays.sort(S);
		res.add(new ArrayList<Integer>());

		for (int i : S) {
			List<List<Integer>> tmp = new ArrayList();
			for (List<Integer> can : res) {
				List<Integer> copy = new ArrayList(can);
				copy.add(i);
				tmp.add(copy);
			}
			res.addAll(tmp);
		}
		return res;

	}



}