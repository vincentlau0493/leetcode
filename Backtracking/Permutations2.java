public class Permutations2 {


	public List<List<Integer>> permuteUnique(int[] num) {
		Arrays.sort(num);
		List<List<Integer>> res = new ArrayList();
		boolean[] isUsed = new boolean[num.length];
		Arrays.fill(isUsed, false);
		backtracking(num, res, isUsed, new ArrayList<Integer>());
		return res;

	}

	public void backtracking(int[] num, List<List<Integer>> res, boolean[] isUsed, List<Integer> can) {

		if (can.size() == num.length) {
			List<Integer> copy = new ArrayList(can);
			res.add(copy);
			return;
		}
		int pre = Integer.MAX_VALUE;
		for (int i=0; i<num.length; i++) {
			if (isUsed[i] || num[i] == pre) continue;
			can.add(num[i]);
			isUsed[i] = true;
			backtracking(num, res, isUsed, can);
			can.remove(can.size()-1);
			isUsed[i] = false;	
			pre = num[i];		
		}


	}

}