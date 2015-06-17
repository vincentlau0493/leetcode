public class BinaryTreeLevelOrderTraversal {

	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList();
		if (root == null) return res;
		Queue<TreeNode> queue = new LinkedList();
		queue.offer(root);

		while (!queue.isEmpty()) {
			int size = queue.size();
			List<Integer> can = new ArrayList();
			for (int i=0; i<size; i++) {
				TreeNode node = queue.poll();
				can.add(node.val);
				if (node.left != null) queue.offer(node.left);
				if (node.right != null) queue.offer(node.right);
			}
			res.add(can);
		}
		return res;
	}

	public void preOrderSolution(List<List<Integer>> res, TreeNode node, int depth) {

		if (node == null) return;
		if (res.size() == depth)
			res.add(new ArrayList<Integer>());

		res.get(depth).add(node.val);
		preOrderSolution(res, node.left, depth + 1);
		preOrderSolution(res, node.right, depth + 1);

	}


}