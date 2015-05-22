public class MaximumSubarray {

	public static void main(String[] args) {

		int[] A = {2,1,-3,4,-1,2,1,-5,4};
		System.out.println(bruteForce(A));
		System.out.println(dynamicProgramming(A));
		System.out.println(divideConquer(A));
	}

	public static int bruteForce(int[] A) {

		int max = Integer.MIN_VALUE;
		for (int i=0; i<A.length; i++) {
			int cur = 0;
			max = Math.max(cur, max);
			for (int j=i; j<A.length; j++) {
				cur += A[j];
				max = Math.max(cur, max);
			}
		}
		return max;
	}

	public static int dynamicProgramming(int[] A) {

		if (A.length == 0) return 0;

		int cur = A[0];
		int max = cur;

		for (int i=1; i<A.length; i++) {

			if (cur < 0)
				cur = A[i];
			else
				cur += A[i];
			max = Math.max(max, cur);
		}
		return max;
	}

	public static int divideConquer(int[] A) {
		return maxSubarray(A, 0, A.length-1);
	}

	//helper 
	public static int maxSubarray(int[] A, int start, int end) {

		if (start > end) return Integer.MIN_VALUE;
		if (start == end) return A[start];

		int mid = start + (end - start) / 2;
		int leftMax = maxSubarray(A, start, mid);
		int rightMax = maxSubarray(A, mid+1, end);

		//cross left and right
		int midLeftMax = Integer.MIN_VALUE;
		int midRightMax = Integer.MIN_VALUE;
		int sum = 0;
		for (int i=mid+1; i<=end; i++) {
			sum += A[i];
			midRightMax = Math.max(midRightMax, sum);
		}
		sum = 0;
		for (int i=mid; i>=start; i--) {
			sum += A[i];
			midLeftMax = Math.max(midLeftMax, sum);
		}
		int midMax = midLeftMax + midRightMax;

		int max = Math.max(leftMax, rightMax);
		max = Math.max(max, midMax);

		return max;
	}



}