public class UniqueBinarySearchTrees {

	public static int numTrees(int n) {

		int[] G = new int[n+1];
		G[0] = G[1] = 1;
		for (int i=2; i<=n; i++) {
			for (int j=1; j<=i; j++) {
				int F = G[j-1]*G[i-j];
				G[i] += F;
			}
		}
		return G[n];
	}

}