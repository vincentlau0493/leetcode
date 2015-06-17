public class ConstructBinaryTreeInorderPostorderTraversal {


	public TreeNode buildTree(int[] inorder, int[] postorder) {
		return buildTree(inorder, 0, inorder.length-1, postorder, postorder.length-1);
	}

	public TreeNode buildTree(int[] inorder, int inStart, int inEnd, int[] postorder, int postIndex) {

		if (inStart > inEnd || postIndex < 0) return null;
		TreeNode root = new TreeNode(postorder[postIndex]);
		int mid = findIndex(inorder, inStart, inEnd, postorder[postIndex]);

		root.right = buildTree(inorder, mid+1, inEnd, postorder, postIndex-1);
		root.left = buildTree(inorder, inStart, mid-1,postorder, postIndex - (inEnd-mid) - 1);
		return root;
	}

	public int findIndex(int[] num, int start, int end, int target) {
		for (int i=start; i<=end; i++) {
			if (num[i] == target) return i;
		}
		return -1;
	}
}