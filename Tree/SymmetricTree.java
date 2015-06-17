public class SymmetricTree {
	public boolean isSymmetric(TreeNode root) {
		if (root == null) return true;
		return isSymmetric(root.left, root.right);
	}
	// top down
	public boolean isSymmetric(TreeNode n1, TreeNode n2) {
		if (n1 == null ^ n2 == null) return false;
		if (n1 == null && n2 == null) return true;
		return n1.val == n2.val && isSymmetric(n1.left, n2.right) && isSymmetric(n1.right, n2.left);
	}


	public boolean iterative(TreeNode root) {

		Stack<TreeNode> leftStack = new Stack<>();
		Stack<TreeNode> rightStack = new Stack<>();

		if (root == null) return true;
		leftStack.push(root);
		rightStack.push(root);

		while (!leftStack.isEmpty() && !rightStack.isEmpty()) {

			TreeNode leftNode = leftStack.pop();
			TreeNode rightNode = rightStack.pop();

			if (leftNode.val != rightNode.val) return false;
			if ((leftNode.left==null ^ rightNode.right==null) || (leftNode.right==null ^ rightNode.left==null)) return false;

			if (leftNode.left != null && rightNode.right != null) {
				leftStack.push(leftNode.left);
				rightStack.push(rightNode.right);
			}
			if (leftNode != rightNode && leftNode.right != null && rightNode.left != null) {
				leftStack.push(rightNode.left);
				rightStack.push(leftNode.right);
			}  			
		}

		return leftStack.isEmpty() && rightStack.isEmpty();
	}

	public boolean betterIterative(TreeNode root) {

		Stack<TreeNode> stack = new Stack<>();
		if (root == null) return true;

		stack.push(root); // left
		stack.push(root); // right

		while (!stack.isEmpty()) {
			TreeNode rightNode = stack.pop();
			TreeNode leftNode = stack.pop();

			if (leftNode.val != rightNode.val) return false;

			if ((leftNode.left == null ^ rightNode.right == null) || (leftNode.right == null ^ rightNode.left == null))
				return false;

			if (leftNode.left != null && rightNode.right != null) {
				stack.push(leftNode.left);
				stack.push(rightNode.right);
			}

			if (leftNode != rightNode && leftNode.right != null && rightNode.left != null) {
				stack.push(rightNode.left);
				stack.push(leftNode.right);
			}			
		}
		return true;
	}




}