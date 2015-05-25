public class Triangle {

	public static int minimumTotal(List<List<Integer>> triangle) {


		for (int i=triangle.size()-1; i>=1; i--) {

			List<Integer> curRow = triangle.get(i);
			for (int j=0; j<curRow.size()-1; j++) {

				int tmp = triangle.get(i-1).get(j) + Math.min(curRow.get(j), curRow.get(j+1));
				triangle.get(i-1).set(j, tmp);

			}


		}


		return triangle.get(0).get(0);
	}

}