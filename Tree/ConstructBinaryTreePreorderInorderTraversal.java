public class ConstructBinaryTreePreorderInorderTraversal {
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		return buildTree(preorder, inorder, 0, 0, inorder.length-1);
	}

	public TreeNode buildTree(int[] preorder, int[] inorder, int preIndex, int inStart, int inEnd) {
		if (inStart > inEnd || preIndex >= preorder.length) return null;
		TreeNode root = new TreeNode(preorder[preIndex]);
		int mid = findIndex(inorder, inStart, inEnd, preorder[preIndex]);
		root.left = buildTree(preorder, inorder, preIndex+1, inStart, mid-1);
		root.right = buildTree(preorder, inorder, preIndex + mid - inStart + 1, mid+1, inEnd);
		return root;
	}

	public int findIndex(int[] num, int start, int end, int target) {
		for (int i=start; i<=end; i++) {
			if (num[i] == target) return i;
		}
		return -1;
	}

}