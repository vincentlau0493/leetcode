public class BinaryTreeInorderTraversal {

	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList();
		helper(root, res);
		return res;
	}

	public void helper(TreeNode root, List<Integer> res) {
		if (root == null) return;
		helper(root.left, res);
		res.add(root.val);
		helper(root.right, res);
	}

	
	public List<Integer> iterative(TreeNode root) {

		Stack<TreeNode> stack = new Stack();
		List<Integer> res = new ArrayList();

		while (true) {

			while (root != null) {
				stack.push(root);
				root = root.left;
			}
			if (stack.isEmpty()) break;

			TreeNode node = stack.pop();
			res.add(node.val);
			root = node.right;
		}

		return res;
	}

}