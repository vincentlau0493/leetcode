public class BinaryTreeRightSideView {
	//level order, O(n);
	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> res = new ArrayList();
		Queue<TreeNode> queue = new LinkedList();
		if (root == null) return res;
		queue.offer(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i=0; i<size; i++) {
				TreeNode ele = queue.poll();
				if (i == 0) res.add(ele.val);
				if (ele.right != null) queue.offer(ele.right);
				if (ele.left != null) queue.offer(ele.left);
			}
		}
		return res;

	}

	// divide and conquer, O(nlogn)
	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> res = new ArrayList();
		if (root == null) return res;
		res.add(root.val);
		List<Integer> leftList = rightSideView(root.left);
		List<Integer> rightList = rightSideView(root.right);
		for (int i=0; i<Math.max(leftList.size(), rightList.size()); i++) {
			Integer can = i<rightList.size() ? rightList.get(i) : leftList.get(i);
			res.add(can);
		}
		return res;
	}

	//get the depth, O(n);
	public void rightView(TreeNode root, List<Integer> res, int depth) {
		if (root == null) return;
		if (res.size() == depth) res.add(root.val);

		rightView(root.right, res, depth + 1);
		rightView(root.left, res, depth + 1);
	}
}

