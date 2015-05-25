import java.util.*;

public class UniqueBinarySearchTrees2 {

	public static List<TreeNode> generateTrees(int n) {

		
		return generateTrees(1, n);
	}

	public static List<TreeNode> generateTrees(int start, int end) {

		List<TreeNode> res = new ArrayList<TreeNode>();
		if (start > end) {
			res.add(null);
			return res;
		}

		if (start == end) {
			TreeNode root = new TreeNode(start);
			res.add(root);
			return res;
		}

		for (int i=start; i<=end; i++) {



			List<TreeNode> lNode = generateTrees(start, i-1);
			List<TreeNode> rNode = generateTrees(i+1, end);

			for (TreeNode left : lNode) {
				for (TreeNode right : rNode) {
					TreeNode root = new TreeNode(i);
					root.left = left;
					root.right = right;
					res.add(root);
				}
			}
		}

		return res;
	}

}