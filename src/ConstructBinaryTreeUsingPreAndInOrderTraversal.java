import java.util.HashMap;

/*
http://oj.leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 */
public class ConstructBinaryTreeUsingPreAndInOrderTraversal {
	class Index{
		int ps;
	}
	public TreeNode buildTree(int[] preorder,int[] inorder) {
		HashMap<Integer,Integer> map=new HashMap<Integer, Integer>();
		for(int i=0;i<inorder.length;i++) {
			map.put(inorder[i],i);
		}
		Index index=new Index();
		index.ps=0;
		return buildTreeUtil(preorder,map, index, 0, inorder.length - 1);
	}

	private TreeNode buildTreeUtil(int[] preorder, HashMap<Integer,Integer> hashMap, Index index, int is, int ie) {
		if(index.ps==preorder.length || is>ie) {
			return null;
		}

		TreeNode root=new TreeNode(preorder[index.ps]);
		int pos=index.ps++;

		root.left=buildTreeUtil(preorder, hashMap,index , is,hashMap.get(preorder[pos])-1);
		root.right=buildTreeUtil(preorder, hashMap,index, hashMap.get(preorder[pos])+1, ie);
		return root;
	}
}
