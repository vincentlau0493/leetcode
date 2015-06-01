public class LetterCombinationsPhoneNumber {

	static String[] keyPad = {" ", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

	public List<String> letterCombinations(String digits) {
		List<String> res = new ArrayList();
		if (digits.length() == 0) return res;
		backtracking(digits, 0, res, "");
		return res;
	}

	public void backtracking(String digits, int idx, List<String> res, String can) {

		if (idx == digits.length()) {
			res.add(can);
			return;
		}
		String key = keyPad[digits.charAt(idx) - '0'];
		for (int i=0; i<key.length(); i++) {
			backtracking(digits, idx+1, res, can + key.charAt(i));
		}
	}

	public void BFS(String digits) {
		
		List<String> res = new ArrayList();
		if (digits.length() == 0) return res;		
		
	}

}