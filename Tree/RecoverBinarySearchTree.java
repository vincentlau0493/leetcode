public class RecoverBinarySearchTree {

	public void recoverTree(TreeNode root) {

		TreeNode firstWrong = null;
		TreeNode secondWrong = null;

		TreeNode pre = null;
		TreeNode cur = root;
		Stack<TreeNode> stack = new Stack();

		while (true) {
			while (cur != null) {
				stack.push(cur);
				cur = cur.left;
			}
			if (stack.isEmpty()) break;
			cur = stack.pop();
			if (pre != null) {
				if (pre.val >= cur.val) { // wrong
					if (firstWrong == null) { // first update
						firstWrong = pre;
						secondWrong = cur;
					} else {
						secondWrong = cur;
					}
				}
			}
			pre = cur;
			cur = cur.right;
		}

		int tmp = firstWrong.val;
		firstWrong.val = secondWrong.val;
		secondWrong.val = tmp;
	}

}