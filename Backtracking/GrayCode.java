public class GrayCode {

	public List<Integer> grayCode(int n) {

		List<Integer> res = new ArrayList();
		res.add(0);
		if (n == 0) return res;
		
		for (int i=0; i<n; i++) {
			int size = res.size();
			for (int j=size-1; j>=0; j--) {
				int code = res.get(j);
				res.add(code|(1<<i));
			}
		}

		return res;
	}

}