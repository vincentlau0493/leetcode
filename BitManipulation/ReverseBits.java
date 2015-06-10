public class ReverseBits {

	HashMap<Byte, Integer> cache = new HashMap<>();

	public int reverseBits(int n) {

		int res = 0;
		for (int i=0; i<4; i++) {
			byte b = (byte)((n>>(i*8))&0xFF);
			res = res<<8 | reverse(b);
		}
		return res;
	}


	public int reverse(byte n) {
		if (cache.containsKey(n)) return cache.get(n);
		int res = 0;
		for (int i=0; i<8; i++) {
			res = (res<<1) | (n>>i&1);
		}
		cache.put(n, res);
		return res;
	}


}