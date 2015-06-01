public class RestoreIPAddresses {


	public List<String> restoreIpAddresses(String s) {
		List<String> res = new ArrayList();
		backtracking(s, 0, res, new ArrayList<String>());
		return res;
	}

	public void backtracking(String ip, int idx, List<String> res, List<String> can) {

		if (ip.length() == idx && can.size() == 4) {

			StringBuilder sb = new StringBuilder();
			sb.append(can.get(0));
			for (int i=1; i<can.size(); i++) {
				sb.append(".");
				sb.append(can.get(i));
			}
			res.add(sb.toString());
			return;
		}

		if (can.size() == 4) return;

		for (int i=idx+1; i<=idx+3 && i <= ip.length(); i++) {
			String piece = ip.substring(idx, i);
			if (isValid(piece)) {
				can.add(piece);
				backtracking(ip, i, res, can);
				can.remove(can.size()-1);
			}
		}
	}

	public boolean isValid(String piece) {

		if (piece.length() > 1 && piece.charAt(0) == '0') return false;
		int num = Integer.parseInt(piece);

		return num <= 255;

	}

}