public class RemoveDuplicates {
    public  int removeDuplicates(int [] src) {
		if(src==null || src.length==0) {
			return 0;
		}
		int i=0,j=1;
		while(j<src.length) {
			if(src[i]!=src[j]) {
				src[++i]=src[j];
			}
			j++;
		}
		return i+1;
	}
}
