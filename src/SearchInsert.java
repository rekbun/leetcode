public class SearchInsert {
    public int searchInsert(int[] src,int k) {
		if(src==null || src.length==0) {
			return -1;
		}

		int s=0,e=src.length-1;
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
	    return e+1;	
	}
}
