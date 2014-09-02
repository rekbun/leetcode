package leetcode;

public class RemoveElement {
    public int removeElement(int [] src,int k) {
		if(src==null || src.length==0 ) {
			return 0;
		}
		int i=0,j=0;
		while(j<src.length) {
			if(src[j]!=k) {
				src[i++]=src[j];
			}
			j++;
		}
		return i;
    }
}
