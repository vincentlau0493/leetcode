public class TrappingRainWater {

	public int towPassesTrap(int[] A) {

		int n = A.length;
		if (n <= 1) return 0;

		int[] helper = new int[n];
		helper[0] = A[0];
		for (int i=1; i<n; i++) {
			helper[i] = Math.max(helper[i-1],A[i]);
		}

		int res = 0;
		for (int i=n-1; i>=0; i--) {
			int tmp = helper[i];
			helper[i] = i==n-1 ? A[i] : Math.max(A[i], helper[i+1]);
			res += Math.max(0, Math.min(helper[i], tmp) - A[i]);
		}

		return res;
	}

	public int stackTrap(int[] A) {

		int n = A.length;
		if (n <= 1) return 0;
		Stack<Integer> stack = new Stack<>();
		int i = 0;
		int res = 0;
		while (i < n) {

			if (stack.isEmpty() || A[stack.peek()] > A[i]) {
				stack.push(i++);
				continue;
			}

			int height = A[stack.pop()];
			if (stack.isEmpty()) continue;
			res += (Math.min(A[stack.peek()], A[i]) - height) * (i-stack.peek()-1);
		}

		return res;
	}


}