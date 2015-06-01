public class EvaluateReversePolishNotation {


	public int evalRPN(String[] tokens) {

		Stack<Long> stack = new Stack<>();

		int i=0;
		while (i < tokens.length) {

			if (tokens[i].charAt(0)-'0'>=0 && tokens[i].charAt(0)-'0'<=9 || tokens[i].length()>1) {
				long tmp = (long)Integer.parseInt(tokens[i++]);
				stack.push(tmp);
			}

			else {
				long n2 = stack.pop();
				long n1 = stack.pop();
				stack.push(calculate(n1, tokens[i++], n2));
			}


		}
    long res = stack.peek();

		return res >= Integer.MAX_VALUE ? Integer.MAX_VALUE : (int)res;
	}	

	//helper
	public long calculate(long num1, String operator, long num2) {

        long result = 0;
        switch (operator) {
            
            case "*":
                result = num1*num2;
                break;
            case "/":
                if (num2 == 0)
                    result = Long.MAX_VALUE;
                else
                    result = num1/num2;
                break;
            case "+":
                result = num1+num2;
                break;
            case "-":
                result = num1-num2;
                break;
            
        }
        return result;

	}


}