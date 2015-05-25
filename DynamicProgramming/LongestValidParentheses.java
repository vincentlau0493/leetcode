import java.util.*;

public class LongestValidParentheses {

	public static int longestValidParentheses(String s) {

		s = " " + s;
		int n = s.length();

		int[] dp = new int[n];

		for (int i=1; i<n; i++) {

			if (s.charAt(i) == '(') {
				dp[i] = 0;
			} else {

				if (s.charAt(i-1) == '(') {
					dp[i] = dp[i-2] + 2;
				} else {

					if (s.charAt(i-dp[i-1]-1) == '(') {
						dp[i] = dp[i-dp[i-1]-2] + 2 + dp[i-1];
					} else {
						dp[i] = 0;
					}

				}
			}
		} 

		int res = 0;
		for (int i=1; i<n; i++) {
			res = Math.max(res, dp[i]);
		}
		return res;
	}

	public static int stackSolution(String s) {
		Stack<Integer> stack = new Stack(); //index of invalid

		for (int i=0; i<s.length(); i++) {
			if (stack.isEmpty() || s.charAt(i) == '(') {
				stack.push(i);
			} else {
					if (s.charAt(stack.peek()) == '(')
						stack.pop();
					else
						stack.push(i);
			}
		}

		int a = s.length();
		int b = 0;
		int res = 0;
		while (!stack.isEmpty()) {
			b = stack.pop();
			res = Math.max(res, a - b - 1);
			a = b;
		}
		res = Math.max(res, a); //important
		return res;
	}


}