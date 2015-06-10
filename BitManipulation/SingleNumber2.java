public class SingleNumber2 {

	public int singleNumber(int[] A) {

		int res = 0;
		for (int bit=0; bit<Integer.SIZE; bit++) {
			int ones = 0;
			for (int i=0; i<A.length; i++) {
				if (((A[i]>>bit)&1) == 1) ones++;
			}
			if (ones%3 != 0) res |= (1<<bit);
		}
		return res;
	}


}