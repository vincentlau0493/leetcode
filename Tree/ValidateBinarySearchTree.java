public class ValidateBinarySearchTree {
	TreeNode pre;
	public boolean isValidBST(TreeNode root) {

		return isValidBST(root, Long.MAX_VALUE, Long.MIN_VALUE);

	}

	public boolean isValidBST(TreeNode root, long max, long min) {
		if (root == null) return true;
		if ((long)root.val >= max || (long)root.val <= min) return false;
		return isValidBST(root.left, (long)root.val, min) && isValidBST(root.right, max, (long)root.val);
	}

	// inorder solution
	public boolean inorderIsValidBST(TreeNode cur) {
		// pre node must be less than cur
		if (cur == null) return true;
		//go left
		if (!isValidBST(cur.left)) return false;
		if (pre != null && pre.val >= cur.val) return false;
		pre = cur;
		return isValidBST(cur.right);
	}

}