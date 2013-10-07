public class SearchForARange {
    private int findLow(int[] src,int k,int s,int e) {
		while (s<=e) {
			int mid=(s+e)/2;
			if(0<mid&& src[mid-1]<k && src[mid]==k) {
				return mid;
			}else if(mid==0 && src[mid]==k) {
				return mid;
			}
			else if(src[mid]<k) {
				s=mid+1;
			}else {
				e=mid-1;
			}
		}
		return -1;
	}
	private int findHigh(int[] src,int k,int s,int e) {
		while(s<=e) {
			int mid=(s+e)/2;
			if(mid<src.length-1 && src[mid+1]>k && src[mid]==k) {
				return mid;
			}else if(mid==src.length-1 && src[mid]==k) {
				return mid;
			}else if(src[mid]>k) {
				e=mid-1;
			}else {
				s=mid+1;
			}
		}
		return -1;
	}

	public int[] searchRange(int[] src,int k) {
		if(src==null || src.length==0) {
			return new int[]{-1,-1};
		}
		int si=findLow(src,k,0,src.length-1);
		int ei=findHigh(src,k,0,src.length-1);
		if(si==-1) {
			return new int[]{-1,-1};
		}else {
			return new int[]{si,ei};
		}
		
	}
}
