import java.util.*;

public class InterleavingString {

	public static HashSet<Integer> isVisited = new HashSet<Integer>();

	public static void main(String[] args) {
		String s1 = "aabcc";
		String s2 = "dbbca";
		String s3 = "aadbbbaccc";
		System.out.println(dfs(s1,s2,s3));
	}

	public static boolean isInterleave(String s1, String s2, String s3) {

		if (s1.length() + s2.length() != s3.length()) return false;

		s1 = " " + s1;
		s2 = " " + s2;
		s3 = " " + s3;

		boolean[][] dp = new boolean[s1.length()][s2.length()];
		dp[0][0] = true;

		for (int i=1; i<s1.length(); i++) {
			dp[i][0] = s1.charAt(i) == s3.charAt(i) && dp[i-1][0];
		}
		for (int j=1; j<s2.length(); j++) {
			dp[0][j] = s2.charAt(j) == s3.charAt(j) && dp[0][j-1];
		}

		for (int i=1; i<s1.length(); i++) {
			for (int j=1; j<s2.length(); j++) {

				boolean cur = false;
				if (s1.charAt(i) == s3.charAt(i+j))
					cur |= dp[i-1][j];
				if (s2.charAt(j) == s3.charAt(i+j))
					cur |= dp[i][j-1];				
				dp[i][j] = cur;
			}
		}

		return dp[s1.length()-1][s2.length()-1];
	}

	public static boolean compressSpace(String s1, String s2, String s3) {

		if (s1.length() + s2.length() != s3.length()) return false;

		s1 = " " + s1;
		s2 = " " + s2;
		s3 = " " + s3;

		boolean[] dp = new boolean[s2.length()];
		dp[0] = true;

		for (int i=0; i<s1.length(); i++) {
			for (int j=0; j<s2.length(); j++) {

				if (i==0 && j==0) continue;

				boolean cur = false;
				if (s1.charAt(i) == s3.charAt(i+j))
					cur |= dp[j];
				if (j>0 && s2.charAt(j) == s3.charAt(i+j))
					cur |= dp[j-1];				
				dp[j] = cur;
			}
		}

		return dp[s2.length()-1];
	}

	public static boolean dfs(String s1, String s2, String s3) {

		if (s3.length() == 0) return true;
		if (s1.length() == 0) return s2.equals(s3);
		if (s2.length() == 0) return s1.equals(s3);

		if ((s1.charAt(0) == s3.charAt(0) && dfs(s1.substring(1), s2, s3.substring(1))) || 
				(s2.charAt(0) == s3.charAt(0) && dfs(s1, s2.substring(1), s3.substring(1))) )
			return true;

		return false;

	}







}

