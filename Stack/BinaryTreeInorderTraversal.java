public class BinaryTreeInorderTraversal {

	public List<Integer> inorderTraversal(TreeNode root) {

		List<Integer> res = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<TreeNode>();

		while(true) {

			while (root != null) {
				stack.push(root);
				root = root.left;
			}

			if (stack.isEmpty()) break;
			TreeNode ele = stack.pop();
			res.add(ele.val);
			root = ele.right;

		}

		return res;
	}


}