public class BitwiseNumbersRange {

	public int rangeBitwiseAnd(int m, int n) {

		int res  = 0;
		for (int i=Integer.SIZE-1; i>=0; i--) {

			if ((m>>i&1) == (n>>i&1))
				res |= (n>>i&1)<<i;
			else
				return res;

		}
		return res;

	}

	public int rangeBitwiseAndBetter(int m, int n) {

		int mask = Integer.MAX_VALUE;
		//find leftmost common
		while ((m&mask) != (n&mask)) 
		mask <<= 1;

		return m&mask;

	}



}