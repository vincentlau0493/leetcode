public class MaximumDepthBinaryTree {

	public int maxDepth(TreeNode root) {
		int depth = 0;
		if (root == null) return depth;
		Queue<TreeNode> queue = new LinkedList();
		queue.offer(root);

		while (!queue.isEmpty()) {
			depth++;
			int size = queue.size();
			for (int i=0; i<size; i++) {
				TreeNode node = queue.poll();
				if (node.left != null)
					queue.offer(node.left);
				if (node.right != null)
					queue.offer(node.right);
			}
		}
		return depth;
 	}

 	//recursive
 	public int maxDepth(TreeNode root) {

		if (root == null) return 0;
		return 1 + Math.max(maxDepth(root.left), maxDepth(root.right)); // too slow

 	}


}