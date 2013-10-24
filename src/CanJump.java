/**
 * Created with IntelliJ IDEA.
 * User: rakeshkumar
 * Date: 10/24/13
 * Time: 11:28 AM
 * To change this template use File | Settings | File Templates.
 */
public class CanJump {
	public boolean canJump(int[] input) {
		int last=0;
		int cur=0;
		for(int i=0;i<input.length;i++) {
			if(i>last) {
				last=cur;
			}
			cur=Math.max(cur,i+input[i]);
		}
		if(input.length==1|| cur>=input.length) {
			return true;
		}
		return false;
	}
	public static void main(String[] args) {
		CanJump sol= new CanJump();

		sol.canJump(new int[]{0});
	}
}
