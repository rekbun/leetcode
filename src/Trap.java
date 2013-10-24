/**
 * Created with IntelliJ IDEA.
 * User: rakeshkumar
 * Date: 10/21/13
 * Time: 6:10 PM
 * To change this template use File | Settings | File Templates.
 */
public class Trap {
	public int trap(int [] num) {
		int[] left = new int[num.length];
		int[] right= new int[num.length];
		int max=0;
		for(int i=0;i<num.length;i++) {
			if(max<num[i]) {
				max=num[i];
			}
			left[i]=max;
		}

		max=0;
		for(int i=num.length-1;i>=0;i--) {
			if(max<num[i]) {
				max=num[i];
			}
			right[i]=max;
		}

		int area=0;
		for(int i=0;i<num.length;i++) {
			area+=(Math.min(left[i],right[i])-num[i]);
		}
		return area;
	}
}
