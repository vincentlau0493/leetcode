public class PopulatingNextRightPointersEachNode {

	public void connect(TreeLinkNode root) {

		while (root != null) {
			TreeLinkNode next = root.left;
			if (next == null) return;
			while (root != null) {
				root.left.next = root.right;
				if (root.next != null)
					root.right.next = root.next.left;
				root = root.next;
			}
			root = next;
		}

	}

	// recursive
	public void connect(TreeLinkNode root) {
		if (root == null) return;
		connect(root.left);
		connect(root.right);

		TreeLinkNode leftRunner = root.left;
		TreeLinkNode rightRunner = root.right;
		while (leftRunner != null) {
			leftRunner.next = rightRunner;
			leftRunner = leftRunner.right;
			rightRunner = rightRunner.left;
		}

	}

}