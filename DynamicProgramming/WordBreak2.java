import java.util.*;

public class WordBreak2 {

	static HashMap<String, List<String>> map = new HashMap<String, List<String>>();

	public static void main(String[] args) {

		Set<String> dict = new HashSet<String>();
		dict.add("cat");
		dict.add("cats");
		dict.add("and");
		dict.add("sand");
		dict.add("dog");
		System.out.println(wordBreak("catsanddog", dict));
		System.out.println(recursive("catsanddog", dict));

	}

	public static List<String> recursive(String s, Set<String> dict) {

		List<String> res = new ArrayList<String>();
		int n = s.length();
		if (map.containsKey(s)) return map.get(s);

		for (int i=1; i<=n; i++) {

			String left = s.substring(0, i);
			String right = s.substring(i);
			if (dict.contains(left)) {
				List<String> list = recursive(right, dict);
				for (String r : list) {
					res.add(left + " " + r);
				}
				if (i == n)
					res.add(left);
			}
		}
		map.put(s, res);
		return res;

	}


	public static List<String> wordBreak(String s, Set<String> dict) {

		int n = s.length();
		HashMap<Integer, List<String>> map = new HashMap<Integer, List<String>>();
		List<String> start = new ArrayList<String>(); //preprocess
		start.add("");
		map.put(0, start);

		for (int i=1; i<=n; i++) {
			List<String> tmp = new ArrayList<String>();
			for (String word : dict) {
				int len = word.length();
				if (i-len < 0) continue;

				String piece = s.substring(i-len, i);
				if (piece.equals(word)) {
					for (String can : map.get(i-len)) {
						String newCan = can + piece;
						if (i != n)
							newCan += " ";
						tmp.add(newCan);
					}
				}
			}
			map.put(i, tmp);

		}
		return map.get(n);
	}



}