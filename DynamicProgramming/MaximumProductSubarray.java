public class MaximumProductSubarray {


	public static int maxProduct(int[] A) {

		int upper = 1;
		int lower = 1;
		int max = Integer.MIN_VALUE;

		for (int i=0; i<A.length; i++) {

			int num1 = upper * A[i];
			int num2 = lower * A[i];

			upper = Math.max(num1, num2);
			upper = Math.max(upper, A[i]);
			lower = Math.min(num1, num2);
			lower = Math.min(lower, A[i]);

			max = Math.max(max, upper);
		}

		return max;   
	}

}