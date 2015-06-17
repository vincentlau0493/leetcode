public class MinimumDepthBinaryTree {


	public int minDepth(TreeNode root) {
		int depth = 0;
		if (root == null) return depth;
		Queue<TreeNode> queue = new LinkedList();
		queue.offer(root);

		while (!queue.isEmpty()) {
			depth++;
			int size = queue.size();
			for (int i=0; i<size; i++) {
				TreeNode node = queue.poll();
				if (node.left == null && node.right == null) return depth;
				if (node.left != null)
					queue.offer(node.left);
				if (node.right != null)
					queue.offer(node.right);
			}
		}
		return depth;
 	}

 	//recursive
 	public int minDepth(TreeNode root) {

 		if (root == null) return 0;
 		int left = minDepth(root.left);
 		int right = minDepth(root.right);
 		return (left == 0 || right == 0) ? left+right+1 : 1+Math.min(left, right);

 	}

}