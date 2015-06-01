public class BinaryTreeZigzagLevelOrderTraversal {

	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

		List<List<Integer>> res = new ArrayList();
		if (root == null) return res;

		boolean leftToRight = true;
		Stack<TreeNode> curLevel = new Stack();
		Stack<TreeNode> nextLevel = new Stack();
		curLevel.push(root);

		List<Integer> can = new ArrayList();
		while (!curLevel.isEmpty()) {

			TreeNode node = curLevel.pop();
			can.add(node.val);

			if (leftToRight) {
				if (node.left != null) nextLevel.push(node.left);
				if (node.right != null) nextLevel.push(node.right);
			} else {
				if (node.right != null) nextLevel.push(node.right);
				if (node.left != null) nextLevel.push(node.left);
			}

			if (curLevel.isEmpty()) {

				leftToRight = !leftToRight;
				res.add(can);
				can = new ArrayList();
				curLevel = nextLevel;
				nextLevel = new Stack();
			}

		}
		return res;
	}


}