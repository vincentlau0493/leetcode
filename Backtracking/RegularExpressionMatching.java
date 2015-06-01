public class RegularExpressionMatching {

	public boolean dynamicProgramming(String s, String p) {

		s = " " + s;
		p = " " + p;

		boolean[] dp = new boolean[p.length()];
		boolean last = false;

		for (int i=0; i<s.length(); i++) {
			for (int j=0; j<p.length(); j++) {

				if (i == 0 && j == 0) {
					dp[j] = true;
					continue;
				}
				if (i == 0) {
					dp[j] = p.charAt(j) == '*' ? dp[j-2] : false;
					continue;
				}
				if (j == 0) {
					last = dp[j]; //save previous value
					dp[j] = false;
					continue;
				}		
				boolean tmp = dp[j];
				if (p.charAt(j) != '*') {

					if (p.charAt(j) == '.' || s.charAt(i) == p.charAt(j))
						dp[j] = last;
					else
						dp[j] = false;

				}	else {
					dp[j] = dp[j-2] || ((p.charAt(j-1) == '.' || s.charAt(i) == p.charAt(j-1)) && dp[j]);
				}	
				last = tmp;

			}
		}

		return dp[p.length()-1];

	}

	public boolean isMatch(String s, String p) {

		if (p.length() == 0)
			return s.length() == 0;

		if (p.length() == 1 || p.charAt(1) != '*') {

			if (s.length() == 0) return false;

			if (p.charAt(0) == '.' || s.charAt(0) == p.charAt(0))
				return isMatch(s.substring(1), p.substring(1));
			return false;
		} else {

			if (isMatch(s, p.substring(2)))
				return true;
			int i = 0;
			while (i<s.length() && (p.charAt(0) == '.' || s.charAt(i) == p.charAt(0)))
				if (isMatch(s.substring(++i), p.substring(2)))
					return true;
			return false;
		}
	} 


}