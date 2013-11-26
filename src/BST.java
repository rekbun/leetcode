import java.util.ArrayList;

/*public class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
} */

public class BST {
	private TreeNode root;


	public TreeNode insert(int e) {
		root = insertUtil(root, e);
		return root;
	}

	private TreeNode insertUtil(TreeNode root, int e) {
		if (root == null) {
			root = new TreeNode(e);
			return root;
		}
		if (root.val == e) {
			return root;
		}

		if (root.val > e) {
			root.left = insertUtil(root.left, e);
		} else {
			root.right = insertUtil(root.right, e);
		}
		return root;

	}

	public ArrayList<Integer> pathWithMaxSum() {
		ArrayList<Integer> ret = new ArrayList<Integer>();
		pathUtil(root, ret);
		return ret;
	}


	int pathUtil(TreeNode root, ArrayList<Integer> ret) {
		if (root == null) {
			return 0;
		}

		ArrayList<Integer> left = new ArrayList<Integer>();
		int leftSum = pathUtil(root.left, left);
		ArrayList<Integer> right = new ArrayList<Integer>();
		int rightSum = pathUtil(root.right, right);
		ret.clear();
		int total;
		if (leftSum > rightSum) {
			ret.addAll(left);
			total = leftSum + root.val;
		} else {
			ret.addAll(right);
			total = rightSum + root.val;
		}
		ret.add(0, root.val);
		return total;
	}


	public static void main(String[] args) {
		BST sol = new BST();
		sol.insert(6);
		sol.insert(4);
		sol.insert(2);
		sol.insert(5);
		sol.insert(9);
		sol.insert(8);
		sol.insert(11);
		ArrayList<Integer> ret = sol.pathWithMaxSum();
		for (int i = 0; i < ret.size(); i++) {
			System.out.println(ret.get(i));
		}
	}
}
