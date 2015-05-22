public class FindMedianSortedArrays {

	public static void main(String[] args) {

		int[] A = {2,5,8,10};
		int[] B = {4,15};
		System.out.println(bruteForce(A, B));
		System.out.println(findSmallestKth(A, B));
	}

	public static double bruteForce(int[] A, int[] B) {
		int n = A.length + B.length;
		int[] C = new int[n];
		int i = 0;
		int j = 0;
		int k = 0;
		while (i<A.length && j<B.length) {
			if (A[i] < B[j])
				C[k++] = A[i++];
			else
				C[k++] = B[j++];
		}
		while (i<A.length) 
			C[k++] = A[i++];
		while (j<B.length) 
			C[k++] = B[j++];

		if (n == 1) return C[0];
		return n%2 == 0 ? (double)(C[n/2-1] + C[n/2]) / 2: C[n/2];
	}

	public static double findSmallestKth(int[] A, int[] B) {

		int n = A.length;
		int m = B.length;

		int total = n + m;
		if (total % 2 == 1) 
			return findSmallestKth(A, 0, n, B, 0, m, total/2 + 1);

		return (findSmallestKth(A, 0, n, B, 0, m, total/2) + findSmallestKth(A, 0, n, B, 0, m, total/2+1)) / 2;

	}

	//helper methods
	public static double findSmallestKth(int[] A, int startA, int lenA, int[] B, int startB, int lenB, int k) {

		if (lenB > lenA)
			return findSmallestKth(B, startB, lenB, A, startA, lenA, k);

		if (lenB <= 0)
			return A[startA + k - 1];

		if (k == 1)
			return A[startA] < B[startB] ? A[startA] : B[startB];

		int splitB = Math.min(lenB, k/2);
		int splitA = k - splitB;
		int pivotA = startA + splitA - 1;
		int pivotB = startB + splitB - 1;

		if (A[pivotA] == B[pivotB]) {
			return A[pivotA];
		} else if (A[pivotA] > B[pivotB]) {
			return findSmallestKth(A, startA, splitA, B, pivotB + 1, lenB - splitB, k-splitB);
		} else {
			return findSmallestKth(A, pivotA + 1, lenA - splitA, B, startB, splitB, k-splitA);
		}
	}


}

