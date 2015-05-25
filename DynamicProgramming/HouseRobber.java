public class HouseRobber {
	//4 3 6 1 2 4

	public static int rob(int[] num) {

		if (num.length == 1) return num[0];

		int last = num[0];
		int prev = Math,max(num[1],num[0]);
		int cur = prev;

		for (int i=2; i<num.length; i++) {
			cur = Math.max(num[i]+last, prev);
			int tmp = prev;
			prev = cur;
			last = tmp;
		}

		return cur;
	}



}