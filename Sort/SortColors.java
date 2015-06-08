public class SortColors {


	public void countingSort(int[] A) {

		int zero = 0;
		int one = 0;
		int two = 0;

		for (int i=0; i<A.length; i++) {

			if (A[i] == 0) {
				A[two++] = 2;
				A[one++] = 1;
				A[zero++] = 0;
			} else if (A[i] == 1){
				A[two++] = 2;
				A[one++] = 1;
			} else {
				A[two++] = 2;
			}


		}
	}

	public void partition(int[] A) {

		int l = 0;
		int r = A.length - 1;

		for (int i=0; i<A.length; i++) {
			while (A[i]==2 && i<r) swap(A, i, r--);
			while (A[i]==0 && i>l) swap(A, i, l++);
		}
	}

	public void bruteForce(int[] A) {

		int ones = 0;
		int zeros = 0;
		int twos = 0;

		for (int i=0; i<A.length; i++) {
			if (A[i] == 0) zeros++;
			else if (A[i] == 1) ones++;
			else twos++;
		}
		int k = 0;
		for (int i=0; i<zeros; i++) A[k++] = 0;
		for (int i=0; i<ones; i++) A[k++] = 1;
		for (int i=0; i<twos; i++) A[k++] = 2;

	}


}