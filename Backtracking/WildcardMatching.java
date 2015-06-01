public class WildcardMatching {

	public boolean isMatch(String s, String p) {

		if (p.length() == 0)
			return s.length() == 0;

		if (p.charAt(0) != '*') {

			if (s.length() == 0) return false;

			if (s.charAt(0) == p.charAt(0) || p.charAt(0) == '?')
				return isMatch(s.substring(1), p.substring(1));
			return false;
		} else {

			int i = 1;
			while (i<p.length() && p.charAt(i) == '*')
				i++;

			if (i == p.length()) return true;

			int j = 0;
			while (j < s.length()) {
				if (isMatch(s.substring(j++), p.substring(i)))
					return true;
			}
			return false;
		}
	}

	public boolean dynamicProgramming(String s, String p) {

		s = " " + s;
		p = " " + p;

		boolean[][] dp = new boolean[s.length()][p.length()];
		dp[0][0] = true;

		for (int i=1; i<s.length(); i++) {
			dp[i][0] = false;
		}

		for (int j=1; j<p.length(); j++) {
			dp[0][j] = p.charAt(j) == '*' ? dp[0][j-1] : false;
		}

		for (int i=1; i<s.length(); i++) {
			for (int j=1; j<p.length(); j++) {

				if (p.charAt(j) != '*') {

					if (p.charAt(j) == s.charAt(i) || p.charAt(j) == '?')
						dp[i][j] = dp[i-1][j-1]; 
					else
						dp[i][j] = false;

				} else {

					dp[i][j] = dp[i][j-1] || dp[i-1][j];
				}

			}
		}

		return dp[s.length()-1][p.length()-1];
	}


}