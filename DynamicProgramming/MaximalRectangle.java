import java.util.*;

public class MaximalRectangle {

	public static int maximalRectangle(int[][] matrix) {

		int n = matrix.length;
		if (n == 0) return 0;
		int m = matrix[0].length;
		int res = 0;
		// dp
		for (int i=0; i<n; i++) {
			for (int j=0; j<m; j++) {
				if (i == 0) break;
				matrix[i][j] = matrix[i][j]==0 ? 0 : matrix[i-1][j] + 1;
			}
			res = Math.max(res, maxArea(matrix[i]));
		}
		return res;
	}

	public static int maxArea(int[] nums) {

		int[] A = new int[num.length+1];
		Stack<Integer> stack = new Stack<Integer>();

		for (int i=0; i<nums.length; i++) {
			A[i] = nums[i];
		}
		int res = 0;
		int i = 0;
		while (i < A.length) {
			if (stack.isEmpty() || A[stack.peek()] <= A[i]) {
				stack.push(i++);
			} else {
				int height = A[stack.pop()];
				int width = stack.isEmpty() ? i : i - stack.peek() - 1;
				res = Math.max(res, height * width);
			}
		}
		return res;
	}

}


