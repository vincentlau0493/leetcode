public class SameTree {


	public boolean isSameTree(TreeNode p, TreeNode q) {
		if (p == null ^ q == null) return false;
		if (p == null && q == null) return true;
		return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
	}


	public boolean iterative(TreeNode p, TreeNode q) {

		if (p == null ^ q == null) return false;
		if (p == null && q == null) return true;

		Stack<TreeNode> stack = new Stack<>();		
		stack.push(p);
		stack.push(q);

		while (!stack.isEmpty()) {

			TreeNode n1 = stack.pop();
			TreeNode n2 = stack.pop();

			if (n1.val != n2.val || (n1.left==null^n2.left==null) || (n1.right==null^n2.right==null)) return false;

			if (n1.left != null && n2.left != null) {
				stack.push(n1.left);
				stack.push(n2.left);
			}
			if (n1.right != null && n2.right != null) {
				stack.push(n1.right);
				stack.push(n2.right);
			}
		}

		return true;
	}

}