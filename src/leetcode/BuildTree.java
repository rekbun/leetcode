package leetcode;

/**
 * Created with IntelliJ IDEA.
 * User: rakeshkumar
 * Date: 10/7/13
 * Time: 9:14 PM
 * To change this template use File | Settings | File Templates.
 */
public class BuildTree {
	private int find(int[] inorder, int ini, int inlen,int val) {
		if(ini>inlen) {
			return -1;
		}
		for(int i=ini;i<=inlen;i++) {
			if(inorder[i]==val) {
				return i;
			}
		}
		return -1;
	}
	public TreeNode buildTree(int [] inorder,int [] postorder) {
		if(inorder==null ||postorder==null) {
			return null;
		}
		ReferenceCounting cnt=new ReferenceCounting();
		cnt.poi=postorder.length-1;
		return buildTreeUtil(inorder,postorder,0,inorder.length-1,cnt);
	}
	class ReferenceCounting{
		   int poi;
	}
	private TreeNode buildTreeUtil(int[] inorder, int[] postorder, int ini, int inlen, ReferenceCounting cnt) {
		if(cnt.poi<0 || ini>inlen) {
			return null;
		}

		TreeNode node = new TreeNode(postorder[cnt.poi]);
		cnt.poi--;
		int idx=find(inorder,ini,inlen,node.val);
		if(idx==-1) {
			return node;
		}
		node.right=buildTreeUtil(inorder,postorder,ini,idx-1,cnt);
		node.left=buildTreeUtil(inorder,postorder,idx+1,inlen,cnt);
		return node;
	}
}
