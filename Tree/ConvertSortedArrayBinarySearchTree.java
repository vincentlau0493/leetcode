public class ConvertSortedArrayBinarySearchTree {

	public TreeNode sortedArrayToBST(int[] num) {

		if (num.length == 0) return null;
		Stack<TreeNode> nodeStack = new Stack();
		Stack<Integer> indexStack = new Stack();
		TreeNode head = new TreeNode(0); // placeholder
		nodeStack.push(head);
		indexStack.push(num.length-1);
		indexStack.push(0);



		while (!nodeStack.isEmpty()) {
			int start = indexStack.pop();
			int end = indexStack.pop();
			TreeNode node = nodeStack.pop();

			int mid = start + (end - start) / 2;
			node.val = num[mid];
			if (start <= mid-1) {
				TreeNode left = new TreeNode(0);
				node.left = left;
				nodeStack.push(left);
				indexStack.push(mid-1);
				indexStack.push(start);
			}
			if (mid+1 <= end) {
				TreeNode right = new TreeNode(0);
				node.right = right;
				nodeStack.push(right);
				indexStack.push(end);
				indexStack.push(mid+1);
			}			
		}
		return head;
	}

	public TreeNode sortedArrayToBST(int[] num, int start, int end) {

		if (start > end) return null;
		if (start == end) return new TreeNode(num[start]);

		int mid = start + (end - start) / 2;
		TreeNode root = new TreeNode(num[mid]);
		root.left = sortedArrayToBST(num, start, mid-1);
		root.right = sortedArrayToBST(num, mid+1, end);
		return root;
	}
}