public class BinaryTreeZigzagLevelOrderTraversal {

	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList();
		if (root == null) return res;
		Stack<TreeNode> curLevel = new Stack();
		Stack<TreeNode> nextLevel = new Stack();
		boolean leftToRight = true;
		curLevel.push(root);
		while (!curLevel.isEmpty()) {
			int size = curLevel.size();
			List<Integer> can = new ArrayList();
			for (int i=0; i<size; i++) {
				TreeNode node = curLevel.pop();
				can.add(node.val);
				if (leftToRight) {
					if (node.left != null) nextLevel.push(node.left);
					if (node.right != null) nextLevel.push(node.right);
				} else {
					if (node.right != null) nextLevel.push(node.right);
					if (node.left != null) nextLevel.push(node.left);					
				}
			}
			res.add(can);
			leftToRight = !leftToRight;
			curLevel = nextLevel;
			nextLevel = new Stack();
		}
		return res;
	}

	// recursive
	public void helper(TreeNode node, List<List<Integer>> res, int depth) {

		if (node == null) return;
		if (depth == res.size()) {
			res.add(new LinkedList<Integer>());
		}

		if (depth % 2 == 0) res.get(depth).add(node.val);
		else res.get(depth).add(0, node.val);

		helper(node.left, res, depth + 1);
		helper(node.right, res, depth + 1);
	}

}
