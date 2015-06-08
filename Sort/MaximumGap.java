public class MaximumGap {

	public int maximumGap(int[] num) {

		int n = num.length;
		if (n <= 1) return 0;

		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for (int i=0; i<n; i++) {
			min = Math.min(min, num[i]);
			max = Math.max(max, num[i]);
		}

		int bucketLen = (max - min) / n + 1;
		int[] bucketMax = new int[n];
		int[] bucketMin = new int[n];
		Arrays.fill(bucketMin, Integer.MAX_VALUE);
		Arrays.fill(bucketMax, Integer.MIN_VALUE);

		for (int i=0; i<n; i++) {
			int pos = (num[i] - min) / bucketLen;
			bucketMax[pos] = Math.max(bucketMax[pos], num[i]);
			bucketMin[pos] = Math.min(bucketMin[pos], num[i]);
		}

		int gap = 0;
		int pre = min;
		for (int i=0; i<n; i++) {
			if (bucketMax[i] != Integer.MIN_VALUE) {
				gap = Math.max(gap, bucketMin[i] - pre);
				pre = bucketMax[i];
			}

		}
		return gap;
	}



}