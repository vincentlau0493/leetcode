import java.util.*;

public class Permutations {

	public static void main(String[] args) {

		int[] A = {1,2,3,4};

		System.out.println(permute(A));
		System.out.println(permuteInplace(A));
	}


	public static List<List<Integer>> permute(int[] num) {

		List<List<Integer>> res = new ArrayList();
		boolean[] isUsed = new boolean[num.length];
		Arrays.fill(isUsed, false);
		backtracking(num, res, isUsed, new ArrayList<Integer>());
		return res;

	}

	public static List<List<Integer>> permuteInplace(int[] num) {

		List<List<Integer>> res = new ArrayList();
		backtracking(num, res, 0);
		return res;		


	}

	public static void backtracking(int[] num, List<List<Integer>> res, int idx) {

		if (idx == num.length) {
			List<Integer> can = new ArrayList();
			for (int a : num) {
				can.add(a);
			}
			res.add(can);
			return;
		}

		for (int i=idx; i<num.length; i++) {

			swap(num, idx, i);
			backtracking(num, res, idx+1);
			swap(num, idx, i);

		}

	}

	public static void swap(int[] num, int idx1, int idx2) {

		int tmp = num[idx1];
		num[idx1] = num[idx2];
		num[idx2] = tmp;

	}

	// helper
	public static void backtracking(int[] num, List<List<Integer>> res, boolean[] isUsed, List<Integer> can) {

		if (can.size() == num.length) {
			List<Integer> copy = new ArrayList(can);
			res.add(copy);
			return;
		}

		for (int i=0; i<num.length; i++) {
			if (isUsed[i]) continue;
			can.add(num[i]);
			isUsed[i] = true;
			backtracking(num, res, isUsed, can);
			can.remove(can.size()-1);
			isUsed[i] = false;			
		}


	}

}