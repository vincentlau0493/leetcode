public class PermutationSequence {

	public String getPermutation(int n, int k) {

		k--;
		if (k < 0 || n <= 0) return "";
		int[] factorial = new int[n];
		List<Integer> nums = new ArrayList<Integer>();
		for (int i=0; i<n; i++) {
			if (i == 0) {
				factorial[i] = 1;
			} else {
				factorial[i] = i*factorial[i-1];
			}
			nums.add(i+1);
		}
		StringBuilder sb = new StringBuilder();
		while (nums.size() > 0) {
			int len = nums.size();
			int group = k / factorial[len-1];
			int pos = k % factorial[len-1];
			sb.append(nums.remove(group));
			k = pos;
		}

		return sb.toString();


	}

}