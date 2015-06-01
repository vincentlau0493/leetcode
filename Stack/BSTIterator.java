public class BSTIterator {

	Stack<TreeNode> stack;

	public BSTIterator(TreeNode root) {
		stack = new Stack<TreeNode>();
		goDown(root);
	}
	/** @return whether we have a next smallest number */
	public boolean hasNext() {
		return !stack.isEmpty();
	}

	/** @return the next smallest number */
	public int next() {
		TreeNode ele = stack.pop();
		goDown(ele.right);
		return ele.val;
	}

	public void goDown(TreeNode cur) {

		while (cur != null) {
			stack.push(cur);
			cur = cur.left;
		}

	}

}