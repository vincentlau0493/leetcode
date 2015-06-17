public class BSTIterator {

	Stack<TreeNode> stack;
	public BSTIterator(TreeNode root) {
		stack = new Stack<>();
		// go left
		goLeft(root);
	}

	/** @return whether we have a next smallest number */
	public boolean hasNext() {
		return !stack.isEmpty();
	}

	/** @return the next smallest number */
	public int next() {
		TreeNode node = stack.pop();
		goLeft(node.right);
		return node.val;
	}

	public void goLeft(TreeNode node) {
		while (node != null) {
			stack.push(node);
			node = node.left;
		}
	}
}