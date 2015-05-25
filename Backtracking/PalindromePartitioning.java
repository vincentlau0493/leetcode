import java.util.*;

public class PalindromePartitioning {

	public static List<List<String>> partition(String s) {

		boolean[][] isPal = new boolean[s.length()][s.length()];

		for (int i=0; i<s.length(); i++) {
			for (int j=0; j<=i; j++) {
				isPal[i][j] = true;
			}
		}

		for (int i=s.length()-1; i>=0; i--) {
			for (int j=s.length()-1; j>i; j--) {
				isPal[i][j] = s.charAt(i) == s.charAt(j) && isPal[i+1][j-1];
			}
		}

		List<List<String>> res = new ArrayList();
		List<String> can = new ArrayList();
		partition(s, 0, res, can, isPal);
		return res;
	}

	public static void partition(String s, int index, List<List<String>> res, List<String> can, boolean[][] isPal) {

		if (index >= s.length()) {
			List<String> copy = new ArrayList(can);
			res.add(copy);
			return;
		}

		for (int i=index; i<s.length(); i++) {

			if (isPal[index][i]) {
				can.add(s.substring(index, i+1));
				partition(s, i+1, res, can, isPal);
				can.remove(can.size()-1);
			}

		}

	}



} 