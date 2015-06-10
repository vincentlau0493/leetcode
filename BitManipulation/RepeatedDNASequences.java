public class RepeatedDNASequences {

	public List<String> findRepeatedDnaSequences(String s) {

		List<String> res = new ArrayList<>();
		// A - 00, C - 01, G - 10, T - 11
		Map<Integer, Boolean> isAdd = new HashMap<>();
		Map<Character, Integer> map = new HashMap<>();
		map.put('A', 0);
		map.put('C', 1);
		map.put('G', 2);
		map.put('T', 3);
		if (s.length() <= 10) return res;
		int i = 0;
		int window = 0;
		while (i<10) {
			window = window<<2 | map.get(s.charAt(i++));
		}
		isAdd.put(window, false);

		int mask = 0;
		for (int j=0; j<20; j++)
			mask = mask<<1 | 1;

		for (; i<s.length(); i++) {
			window = mask&window<<2 | map.get(s.charAt(i));
			if (isAdd.containsKey(window)) {
				if (isAdd.get(window)) continue;
				res.add(s.substring(i-10+1, i+1));
				isAdd.put(window, true);
			} else
				isAdd.put(window, false);
		}
		return res;
	}


}