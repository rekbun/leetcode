public class Solution {
    private int findPivot(int[] src,int s,int e ) {
		while(s<e) {
			int mid=(s+e)/2;
			if(mid+1<src.length && src[mid]>src[mid+1]) {
				return mid;
			}else if(mid+1==src.length) {
				return -1;
			}else if(src[mid]<src[e]) {
				e=mid;
			}else {
				s=mid;
			}
		}
		return -1;
	}
	private int binarySearch(int [] src,int k,int s,int e) {
		if(s==e) {
		    if(src[s]==k) {
		        return s;
		    }
		}
		while(s<=e) {
			int mid=(s+e)/2;
			if(src[mid]==k) {
				return mid;
			}
			if(src[mid]<k) {
				s=mid+1;
			}else {
				e=mid-1;
			}
		}
		return -1;
	}

	public int search(int[] src,int k) {
		if(src==null || src.length==0) {
			return -1;
		}
		int idx=findPivot(src,0,src.length-1);
		if(idx==-1)	{
			return	binarySearch(src,k,0,src.length-1);
		}
		if(src[idx]==k) {
			return idx;
		}
		if(src[src.length-1]<k) {
			return binarySearch(src,k,0,idx-1) ;
		}else {
			return binarySearch(src,k,idx+1,src.length-1);
		}
	}
}
