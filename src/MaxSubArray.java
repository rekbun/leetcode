/**
 * Created with IntelliJ IDEA.
 * User: rakeshkumar
 * Date: 10/24/13
 * Time: 10:23 AM
 * To change this template use File | Settings | File Templates.
 */
public class MaxSubArray {
	public int maxSubArray(int[] A) {
		if(A==null|| A.length==0) {
			return 0;
		}

		int c_max=A[0];
		int r_max=A[0];

		for(int i=1;i<A.length;i++) {
			if(c_max<0) {
				c_max=A[i];
				if(c_max>r_max) {
					r_max=c_max;
				}
				continue;
			}else if(c_max+A[i]>r_max) {
				r_max=c_max+A[i];
			}
			c_max=c_max+A[i];


		}
		return r_max;
	}
}
