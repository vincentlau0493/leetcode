public class LargestNumber {

	public String largestNumber(int[] nums) {

		Comparator<String> comp = new Comparator<String>(){
			public int compare(String s1, String s2) {
				String str1 = s1 + s2;
				String str2 = s2 + s1;
				return str2.compareTo(str1);
			}
		};

		if (nums.length == 0) return "";
		String[] sNums = new String[nums.length];
		for (int i=0; i<nums.length; i++) {
			sNums[i] = nums[i] +"";
		}

		Arrays.sort(sNums, comp);
		if (sNums[0].equals("0")) return "0";

		StringBuilder sb = new StringBuilder();
		for (int i=0; i<nums.length; i++) {
			sb.append(sNums[i]);
		}
		return sb.toString();
	}


}