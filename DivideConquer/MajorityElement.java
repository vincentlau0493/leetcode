public class MajorityElement {

	/*
	 * Several Methods
	 *	1. Hash Table, time n, space n
	 *  2. BST, time nlogn, space n (hit the node, and count plus one)
	 *  3. D&C, time T(n) = T(n/2) + 2n = O(nlogn)
	 *	4. Moore voting algorithm, time n
	 *	5. Bit Manipulation, time 32n
	 */


	public static void main(String[] args) {
		int[] A = {1,5,2,2,5,5,5,5};

		System.out.println(regularSolution(A));
		System.out.println(bitManipulation(A));
		System.out.println(divideConquer(A));
	}

	public static int regularSolution(int[] num) {
		int count = 1;
		int cur = num[0];
		for (int i=1; i<num.length; i++) {
			if (cur == num[i]) {
				count++;
			} else {
				count--;
				if (count <= 0) {
					count = 1;
					cur = num[i];
				}
			}
		}
		return cur;
	}

	public static int divideConquer(int[] num) {
		return divideConquer(num, 0, num.length-1);
	}

	//helper
	public static int divideConquer(int[] num, int start, int end) {

		if (start > end) return Integer.MAX_VALUE;
		if (start == end) return num[start];

		int mid = start + (end - start) / 2;
		int left = divideConquer(num, start, mid);
		int right = divideConquer(num, mid+1, end);

		if (left == right) return left;

		return isMajority(num, left) ? left : right;


	}

	public static boolean isMajority(int[] num, int can) {
		int count = 0;
		for (int i=0; i<num.length; i++) {
			if (can == num[i])
				count++;
		}
		return count > num.length/2;
	}




	public static int bitManipulation(int[] num) {

		int res = 0;
		for (int i=0; i<Integer.SIZE; i++) {
			int count = 0;
			for (int j=0; j<num.length; j++) {
				int tmp = 1 & (num[j]>>i);
				if (tmp == 1) count++;
			}
			if (count > num.length/2)
				res |= 1<<i;
		}
		return res;

	}
}