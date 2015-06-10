public class MajorityElement {


	public int majorityElement(int[] num) {

		int count = 0;
		int target = num[0];

		for (int i=1; i<num.length; i++) {
			if (num[i] == target) {
				count++;
			} else {
				count--;
				if (count < 0) {
					target = num[i];
					count = 0;
				}

			}
		}
		return target;
	}

	public int bitwise(int[] num) {
		int res = 0;
		for (int b=0; b<Integer.SIZE; b++) {
			int ones = 0;
			for (int i=0; i<num.length; i++) {
				ones += (num[i]>>b)&1;
			}
			if (ones > num.length /2)
			    res |= (1<<b);
		}
		return res;
	}

	public int divideConquer(int[] num, int start, int end) {

			if (start == end) return num[start];
			int mid = start + (end-start) / 2;

			int num1 = divideConquer(num, start, mid);
			int num2 = divideConquer(num, mid+1, end);

			if (num1 == num2) return num1;
			return isMajority(num, num1) ? num1 : num2;
	}

	public boolean isMajority(int[] num, int can) {
		int count = 0;
		for (int i=start; i<=end; i++) {
			if (can == num[i])
				count++;
		}
		return count > num.length/2;
	}    

}


