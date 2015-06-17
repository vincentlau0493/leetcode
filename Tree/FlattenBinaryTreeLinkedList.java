public class FlattenBinaryTreeLinkedList {

	// iterative
	public void flatten(TreeNode root) {

		while (root != null) {

			TreeNode last = root.left;
			if (last != null) {
				while (last.right != null) last = last.right;
				last.right = root.right;
				root.right = root.left;
				root.left = null;
			}
			root = root.right;

		}

	}



	// recursive
	public TreeNode flattenTree(TreeNode root) {

		if (root == null) return null;
		if (root.left == null && root.right == null) return root;

		TreeNode leftLast = flattenTree(root.left);
		TreeNode rightLast = flattenTree(root.right);
		TreeNode leftNode = root.left;
		TreeNode rightNode = root.right;

		root.left = null;
		if (leftNode != null) {
			root.right = leftNode;
			leftLast.right = rightNode;
		}

		return rightLast == null ? leftLast : rightLast;

	}


}