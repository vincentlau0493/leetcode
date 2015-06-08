import java.util.*;

public class WordBreak {

	/*
	 * 3 Methods
	 *	1. DP
	 *	2. DFS
	 *	3. BFS
	 */

	static HashMap<Integer, Boolean> map = new HashMap<>();

	public static void main(String[] args) {

		Set<String> dict = new HashSet<String>();
		dict.add("leet");
		dict.add("lee");
		dict.add("code");
		System.out.println(backtracking("leetcode", dict));
		System.out.println(dynamicProgramming("leetcode", dict));
		System.out.println(BFS("leetcode", dict));
	}

	public static boolean dynamicProgramming(String s, Set<String> dict) {

		boolean[] dp = new boolean[s.length() + 1];
		dp[0] = true;

		for (int i=1; i<=s.length(); i++) {
			dp[i] = false;
			for (String word : dict) {
				int wordLen = word.length();
				if (wordLen > i) continue;
				dp[i] = s.substring(i-wordLen, i).equals(word) && dp[i-wordLen];
				if (dp[i])
					break;
			}
		}
		return dp[s.length()];

	}

	public static boolean backtracking(String s, Set<String> dict) {
		if (s.length() == 0) return true;
		boolean isMatch = false;
		for (int i=1; i<=s.length(); i++) {
			String word = s.substring(0, i);
			if (dict.contains(word))
				isMatch = backtracking(s.substring(i), dict);
			if (isMatch)
				return true;			
		}
		return false;
	}

	public static boolean fastBacktracking(String s, Set<String> dict, int idx) {

		if (s.length() == idx) return true;
		if (map.containsKey(idx)) return map.get(idx);

		boolean res = false;
		for (int i=idx+1; i<=s.length(); i++) {
			String piece = s.substring(idx, i);
			if (dict.contains(piece))
				res = fastBacktracking(s, dict, i);
			if (res) break;
		}

		map.put(idx, res);
		return res;

	}



	public static boolean BFS(String s, Set<String> dict) {

		Queue<Integer> queue = new LinkedList<Integer>(); //save index
		if (s.length() == 0) return true;
		Set<Integer> isVisited = new HashSet<Integer>();
		queue.offer(0);

		while (!queue.isEmpty()) {

			int curIdx = queue.poll();
			for (int i=curIdx+1; i<=s.length(); i++) {

				if (isVisited.contains(i)) continue; //has matched

				String word = s.substring(curIdx, i);
				if (dict.contains(word)) {

					if (i == s.length()) return true;
					queue.offer(i);
					isVisited.add(i);

				}

			}
		}

		return false;
	}



}