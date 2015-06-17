public class BinaryTreePreorderTraversal {
	public List<Integer> preorderTraversal(TreeNode root) {

		List<Integer> res = new ArrayList();
		Stack<TreeNode> stack = new Stack();

		while (true) {
			while (root != null) {
				res.add(root.val);
				stack.push(root);
				root = root.left;
			}
			if (stack.isEmpty()) break;
			root = stack.pop().right;
		}
		return res;
	}

	public void helper(TreeNode root, List<Integer> res) {

		if (root == null) return;
		res.add(root.val);
		helper(root.left, res);
		helper(root.right, res);
	}
}