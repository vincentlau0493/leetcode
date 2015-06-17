public class PathSum {

	public boolean hasPathSum(TreeNode root, int sum) {

		if (root == null) return false;
		if (root.left == null && root.right == null && sum - root.val == 0) return true;
		return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);

	}

	public boolean postorderSolution(TreeNode root, int sum) {
		Stack<TreeNode> stack = new Stack();
		if (root == null) return false;
		int curSum = 0;
		TreeNode cur = null;
		TreeNode pre = null;

		stack.push(root);
        curSum = root.val;
		while (!stack.isEmpty()) {

			cur = stack.peek();

			// going down
			if (pre == null || pre.left == cur || pre.right == cur) {
				
				if (cur.left != null) {
					stack.push(cur.left);
					curSum += cur.left.val;
				} else if (cur.right != null) {
					stack.push(cur.right);
					curSum += cur.right.val;					
				} else {
					//leaf
					if (curSum == sum) return true;
					curSum -= stack.pop().val;
				}

			} else if (cur.left == pre) {
				if (cur.right != null) {
					stack.push(cur.right);
					curSum += cur.right.val;
				} else {
				    curSum -= stack.pop().val;
				}
			}  else if (cur.right == pre) {
				curSum -= stack.pop().val;
			}


			pre = cur;
		}
		return false;
	}


}