public class BinaryTreePostorderTraversal {

	public List<Integer> postorderTraversal(TreeNode root) {

		List<Integer> res = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();
		if (root == null) return res;
		stack.push(root);
		TreeNode pre = null;
		while (!stack.isEmpty()) {
			TreeNode cur = stack.peek();
			//go down
			if (pre == null || pre.left == cur || pre.right == cur) {

				if (cur.left != null)
					stack.push(cur.left);
				else if (cur.right != null)
					stack.push(cur.right);
				else
					res.add(stack.pop().val);
			} else if (cur.left == pre) {
				if (cur.right != null)
					stack.push(cur.right);
				else
					res.add(stack.pop().val);
			} else if (cur.right == pre) {
				res.add(stack.pop().val);
			}
			pre = cur;

		}
		return res;
	}




}