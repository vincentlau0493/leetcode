public class UniqueBinarySearchTrees {

	public int numTrees(int n) {
		if (n <= 1) return n;
		int[] G = new int[n+1];
		G[0] = 1;
		for (int i=1; i<=n; i++) {
			int F = 0;
			for (int j=1; j<=i; j++) {
				F += G[j-1] * G[i-j];
			}
			G[i] = F;
		}
		return G[n];
	}


}