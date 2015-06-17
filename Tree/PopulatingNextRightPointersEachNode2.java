public class PopulatingNextRightPointersEachNode2 {

	public void connect(TreeLinkNode root) {

		TreeLinkNode prev = null;
		TreeLinkNode curr = root;
		TreeLinkNode nextHead = null;
		while (curr != null) {
			TreeLinkNode temp = curr;
			while (temp != null) {
				if (temp.left != null) {
					if (nextHead == null) nextHead = temp.left;
					if (prev != null) {
						prev.next = temp.left;
						prev = prev.next;
					} else {
						prev = temp.left;						
					}
				}
				if (temp.right != null) {
					if (nextHead == null) nextHead = temp.right;
					if (prev != null) {
						prev.next = temp.right;
						prev = prev.next;
					} else {
						prev = temp.right;						
					}
				}
				temp = temp.next;

			}
			prev = null;
			curr = nextHead;
			nextHead = null;
		}
	}

	public void connect(TreeLinkNode root) {

		while (root != null) {

			TreeLinkNode temp = new TreeLinkNode(0);
			TreeLinkNode curr = temp;
			while (root != null) {
				if (root.left != null) {curr.next = root.left; curr = curr.next;}
				if (root.right != null) {curr.next = root.right; curr = curr.next;}
				root = root.next;
			}
			root = temp.next;
		}

	}



}
