public class BinaryTreePreorderTraversal {

	public List<Integer> preorderTraversal(TreeNode root) {

		List<Integer> res = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<TreeNode>();

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



}