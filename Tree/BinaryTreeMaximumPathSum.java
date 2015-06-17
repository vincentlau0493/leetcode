public class BinaryTreeMaximumPathSum {
	int max = Integer.MIN_VALUE;
	public int maxPathSum(TreeNode root) {

		goDown(root);
		return max;
	}

	public int goDown(TreeNode node) {
		if (node == null) return 0;
		int leftVal = Math.max(0, goDown(node.left));
		int rightVal = Math.max(0, goDown(node.right));
		max = Math.max(max, leftVal + rightVal + node.val);
		return node.val + Math.max(leftVal, rightVal);
	}


}