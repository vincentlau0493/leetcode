public class NumberOneBits {

	public int hammingWeight(int n) {

		int count = 0;
		for (int i=0; i<Integer.SIZE; i++) {
			count += (n>>i)&1;
		}
		return count;

	}

}