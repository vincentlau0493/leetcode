public class SumRootLeafNumbers {

	int total = 0;
	public int sumNumbers(TreeNode root) {
		sumNumbers(root, 0);
		return total;
	}

	public void sumNumbers(TreeNode root, int cur) {

		if (root == null) return;
		if (root.left == null && root.right == null) 
			total += cur*10 + root.val;

		sumNumbers(root.left, cur*10 + root.val);
		sumNumbers(root.right, cur*10 + root.val);

	}

	// iterative
	public int postOrderSolution(TreeNode root) {

		int total = 0;
		int curSum = 0;
		Stack<TreeNode> stack = new Stack();
		TreeNode cur = null;
		TreeNode pre = null;
		if (root == null) return 0;
		stack.push(root);
		curSum = root.val;

		while (!stack.isEmpty()) {

			cur = stack.peek();
			if (pre == null || pre.left == cur || pre.right == cur) {

				if (cur.left != null) {
					curSum = curSum*10 + cur.left.val;
					stack.push(cur.left);
				} else if (cur.right != null) {
					curSum = curSum*10 + cur.right.val;
					stack.push(cur.right);					
				} else {
					//leaf
					total += curSum;
					curSum /= 10;
					stack.pop(); 
				}

			} else if (cur.left == pre) {

				if (cur.right != null) {
					curSum = curSum*10 + cur.right.val;
					stack.push(cur.right);						
				} else {
					curSum /= 10;
					stack.pop();					
				}

			} else if (cur.right == pre) {
					curSum /= 10;
					stack.pop();				
			}
			pre = cur;

		}
		return total;
	}

}