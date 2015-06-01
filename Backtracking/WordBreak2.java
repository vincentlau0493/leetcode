import java.util.*;

public class WordBreak2 {

	static HashMap<String, List<String>> map = new HashMap<String, List<String>>();
	public static List<String> wordBreak(String s, Set<String> dict) {


		List<String> res = new ArrayList<String>();

		if (map.containsKey(s)) return map.get(s);

		for (int i=1; i<=s.length(); i++) {

			String left = s.substring(0, i);
			String right = s.substring(i);

			if (dict.contains(left)) {

				List<String> list = wordBreak(right, dict);

				for (String r : list) {
					res.add(left + " " + r);
				}

				if (right.length() == 0) res.add(left);

			}
		}

		map.put(s, res);

		return res;

	}

}