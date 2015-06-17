public class BinaryTreeLevelOrderTraversal2 {

	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> res = new ArrayList();
		if (root == null) return res;
		Queue<TreeNode> queue = new LinkedList();
		Stack<List<Integer>> stack = new Stack();
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
			stack.push(can);
		}

		while (!stack.isEmpty())
			res.add(stack.pop());
		return res;
	}

	public void preOrderSolution(List<List<Integer>> res, TreeNode node, int depth) {

		if (node == null) return;

		if (res.size() == depth)
			res.add(0, new ArrayList<Integer>());

		res.get(res.size()-1-depth).add(node.val);

		preOrderSolution(res, node.left, depth + 1);
		preOrderSolution(res, node.right, depth + 1);

	}

}

