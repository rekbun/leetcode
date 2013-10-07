/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
   public ArrayList<Integer> inorderTraversal(TreeNode root) {
		if(root==null) {
			return new ArrayList<Integer>();
		}
		Stack<TreeNode> stack=new Stack<TreeNode>();
		TreeNode cur=root;
		ArrayList<Integer> ret= new ArrayList<Integer>();
		do{
			while(cur!=null) {
				if(cur.right!=null) {
					stack.push(cur.right);
				}
				stack.push(cur);
				cur=cur.left;
			}
            cur=stack.pop();
            ret.add(cur.val);
		    if(stack.empty()) {
                break;
            }
    	  	while(!stack.empty() && (cur.right!=stack.peek())) {
			    cur=stack.pop();
			    ret.add(cur.val);
			    if(stack.empty()) {
                    break;			        
			    }
			}
			if(stack.empty()) {
			    break;
			}
	        if(cur.right==stack.peek()) {
	            cur=stack.pop();    
	        }
	   	}while(!stack.empty()||cur!=null);
		return ret;
	}
}
