public class MinStack {

	Stack<Integer> helper = new Stack<>();
	Stack<Integer> main = new Stack<>();

	public void push(int x) {

		main.push(x);
		if (helper.isEmpty() || helper.peek() >= x) helper.push(x);

	}

	public void pop() {
		int ele = main.pop();
		if (ele == helper.peek()) helper.pop();

		// if (main.pop() == helper.peek()) helper.pop(); //wrong
	}

	public int top() {
		return main.peek();
	}

	public int getMin() {
		return helper.peek();
	}

}