public class WildcardMatching {

	public static boolean recursive(String s, String p) {

		if (p.length() == 0)
			return s.length() == 0;

		if (p.charAt(0) != '*') {

			if (s.length() == 0) return false;

			if (p.charAt(0) == '?' || s.charAt(0) == p.charAt(0))
				return recursive(s.substring(1), p.substring(1));
			else
				return false;

		} else {

			int k = 1;
			while (k<p.length() && p.charAt(k) =='*')
				k++;

			if (k == p.length()) return true;

			if (recursive(s, p.substring(k)))
				return true;

			int i=1;
			while (i<s.length()) {
				if (recursive(s.substring(i++), p.substring(k)))
					return true;
			}
			return false;
		}


	}


	public static boolean dynamicProgramming(String s, String p) {

		s = " " + s;
		p = " " + p;

		int n = s.length();
		int m = p.length();

		boolean[][] dp = new boolean[n][m];
		dp[0][0] = true;

		for (int i=1; i<n; i++) {
			dp[i][0] = false;
		}
		for (int j=1; j<m; j++) {
			if (p.charAt(j) == '*')
				dp[0][j] = dp[0][j-1];
			else
				dp[0][j] = false;
		}

		for (int i=1; i<n; i++) {
			for (int j=1; j<m; j++) {
				if (p.charAt(j) != '*') {
					if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?')
						dp[i][j] = dp[i-1][j-1];
					else 
						dp[i][j] = false;
				} else {

					dp[i][j] = dp[i-1][j] || dp[i][j-1];

				}
			}
		}

		return dp[n-1][m-1];
	}


}