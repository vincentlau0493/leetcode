public class LargestRectangleHistogram {

	public int largestRectangleArea(int[] height) {

		int[] A = new int[height.length + 1];

		for (int i=0; i<height.length; i++) 
			A[i] = height[i];

		int i = 0;
		int max = 0;
		Stack<Integer> stack = new Stack<>();

		while (i<A.length) {

			if (stack.isEmpty() || A[stack.peek()] <= A[i])
				stack.push(i++);
			else {
				int h = A[stack.pop()];
				int width = stack.isEmpty() ? i : i - stack.peek() - 1;
				max = Math.max(h * width, max);

			}
		}
		return max;
	}


}