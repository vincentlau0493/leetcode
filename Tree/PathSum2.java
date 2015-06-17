public class PathSum2 {

	public List<List<Integer>> pathSum(TreeNode root, int sum) {

		List<List<Integer>> res = new ArrayList();
		pathSum(root, sum, res, new ArrayList<Integer>());
		return res;
	}

	public void pathSum(TreeNode node, int curSum, List<List<Integer>> res, List<Integer> can) {

		if (node == null) return;
		can.add(node.val);
		if (node.left == null && node.right == null && curSum - node.val == 0) {
			List<Integer> copy = new ArrayList(can);
			res.add(copy);
			// no return here, need to remove
		}

		if (node.left != null)
			pathSum(node.left, curSum - node.val, res, can);

		if (node.right != null)
			pathSum(node.right, curSum - node.val, res, can);
		
		can.remove(can.size() -1);
	}

	public List<List<Integer>> postorderSolution(TreeNode root, int sum) {

		List<List<Integer>> res = new ArrayList();
		if (root == null) return res;

		List<Integer> can = new ArrayList();
		Stack<TreeNode> stack = new Stack();
		int curSum = root.val;
		can.add(root.val);
		stack.push(root);

		TreeNode cur = null;
		TreeNode pre = null;

		while (!stack.isEmpty()) {

			cur = stack.peek();
			// go down
			if (pre == null || pre.left == cur || pre.right == cur) {

				if (cur.left != null) {
					stack.push(cur.left);
					can.add(cur.left.val);
					curSum += cur.left.val;
				} else if (cur.right != null) {
					stack.push(cur.right);
					can.add(cur.right.val);
					curSum += cur.right.val;					
				} else {
					if (curSum == sum) {
						List<Integer> copy = new ArrayList(can);
						res.add(copy);
					}
					TreeNode node = stack.pop();
					curSum -= node.val;
					can.remove(can.size()-1);
				}

			} else if (cur.left == pre) {

				if (cur.right != null) {
					stack.push(cur.right);
					can.add(cur.right.val);
					curSum += cur.right.val;					
				} else {
					curSum -= stack.pop().val;
					can.remove(can.size()-1);					
				}

			} else if (cur.right == pre) {
				curSum -= stack.pop().val;
				can.remove(can.size()-1);				
			}

			pre = cur;
		}


		return res;
	}

}




