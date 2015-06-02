public class Candy {

	public int candy(int[] ratings) {

		int n = ratings.length;
		int[] helper = new int[n];
		helper[0] = 1;
		//left
		for (int i=1; i<n; i++) {
			if (ratings[i] <= ratings[i-1])
				helper[i] = 1;
			else
				helper[i] = helper[i-1] + 1;
		}
		int total = 0;
		for (int i=n-1; i>=0; i--) {
			int tmp = helper[i];
			if (i == n-1)
				helper[i] = 1;
			else {
				helper[i] = ratings[i]<=ratings[i+1] ? 1 : helper[i+1] + 1;
			}
			total += Math.max(helper[i], tmp);
		}
		return total;
	}



}