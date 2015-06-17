public class BalancedBinaryTree {

	public boolean isBalanced(TreeNode root) {
		// O(n*n)
		if (root == null) return true;
		int left = depth(root.left);
		int right = depth(root.right);
		return Math.abs(left- right) <= 1 && isBalanced(root.left) && isBalanced(root.right);

	}

	public int depth(TreeNode root) {
		if (root == null) return 0;
		int left = depth(root.left);
		int right = depth(root.right);
		return Math.max(left, right) + 1;
	}

	public int height(TreeNode root) {

		if (root == null) return 0;
		int left = height(root.left);
		if (left == -1) return -1;
		int right = height(root.right);
		if (right == -1) return -1;

		return Math.abs(left - right) <= 1 ? Math.max(left, right) + 1 : -1;

	}

}