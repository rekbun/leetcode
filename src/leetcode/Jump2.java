package leetcode;

/**
 * Created with IntelliJ IDEA.
 * User: rakeshkumar
 * Date: 10/23/13
 * Time: 1:15 PM
 * To change this template use File | Settings | File Templates.
 */
public class Jump2 {
	private int jumpUtil(int[] A,int idx,int[] mj) {
		if(idx>=A.length) {
			return 0 ;
		}

		if(mj[idx]!=Integer.MAX_VALUE) {
			return mj[idx];
		}


		int min=Integer.MAX_VALUE;
		for(int i=1;i<=A[idx]&&i<A.length ;i++) {
		 	mj[idx]=Math.min(mj[idx],1+jumpUtil(A,idx+i,mj));
		}
		return mj[idx];
	}
	private int jumpOrderN2(int [] A) {
		if(A==null || A.length==0) {
			return 0;
		}
		int [] mj=new int[A.length+1];
		for(int i=0;i<mj.length;i++) {
			mj[i]=Integer.MAX_VALUE;
		}

		mj[0]=0;
		for(int i=1;i<A.length;i++) {
			for(int j=i-1;j>=0;j--) {
				if(A[j]+j>=i) {
					mj[i]=Math.min(mj[i],1+mj[j]);
				}
			}
		}
		return mj[A.length-1];
	}

	public int jump(int [] A) {
		int cur=0;
		int last=0;
		int steps=0;

		for(int i=0;i<A.length;i++) {
			if(i>last) {
				last=cur;
				steps++;
			}
			cur=Math.max(cur,i+A[i]);
		}
		return steps;
	}
}
