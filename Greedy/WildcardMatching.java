public class WildcardMatching {

	public boolean isMatch(String s, String p) {

		if (p.length() == 0)
			return s.length() == 0;

		if (p.charAt(0) != '*') {
			if (s.length() == 0) return false;
			if (p.charAt(0) == s.charAt(0) || p.charAt(0) == '?')
				return isMatch(s.substring(1), p.substring(1));
			return false;
		} else {

			int i = 1;
			while (i<p.length() && p.charAt(i) == '*')
				i++;
			if (i == p.length()) return true;

			int j=0;
			while (j < s.length())
				if (isMatch(s.substring(j++), p.substring(i)))
					return true;
			return false;
		}


	}



}