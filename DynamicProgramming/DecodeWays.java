public class DecodeWays {



	public static int numDecodings(String s) {

		if (s.length() == 0) return 0;
		s += " ";
		int n = s.length();
		int dp[] = new int[n];

		dp[n-1] = 1;
		dp[n-2] = s.charAt(n-2) == '0' ? 0 : 1;

		for (int i=n-3; i>=0; i--) {

			if (s.charAt(i) == '0') {
				dp[i] = 0;
			} else {

				dp[i] = dp[i+1];
				if (Integer.parseInt(s.substring(i,i+2)) <= 26)
					dp[i] += dp[i+2];
			}

		}
		return dp[0];

	}

	public static int compressDP(String s) {

		if (s.length() == 0) return 0;

		s += " ";
		int n = s.length();

		int pre = 1;
		int cur = s.charAt(n-2) == '0' ? 0 : 1;

		for (int i=n-3; i>=0; i--) {

			if (s.charAt(i) == '0') {
				pre = cur;
				cur = 0;
			} else {
				int tmp = cur;
				if (Integer.parseInt(s.substring(i,i+2)) <= 26) {
					cur += pre;
				}
				pre = tmp;

			}
		}

		return cur;
	}

}

