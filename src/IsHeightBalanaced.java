/*

 */
public class IsHeightBalanaced {
	public boolean isHeightBalanced(TreeNode root) {
		if(root==null) {
			return true;
		}

		BalanceH bh=new BalanceH();
		int h= isHeightBalancedUtil(root,bh);
		if(h<=1 && h>=-1) {
			return true;
		}
		return false;
	}

	class BalanceH {
		int d;
	}

	private int isHeightBalancedUtil(TreeNode root,BalanceH bh) {
		if(root==null) {
			return 0;
		}

		int l=isHeightBalancedUtil(root.left,bh);
		int r=isHeightBalancedUtil(root.right,bh);

		int d=l-r;
		if(d>1 && d<-1) {
			bh.d=d;
		}
		return l>r?l : r;
	}


}
