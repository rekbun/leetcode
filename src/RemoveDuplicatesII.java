public class RemoveDuplicatesII {
	public int removeDuplicates(int[] input ) {
		if(input.length==0) {
			return 0;
		}
		int c_freq=1;
		int el=input[0];
		int j=1;
		for(int i=1;i<input.length;i++) {
			if(input[i]==el) {
				c_freq++;
			}else {
				el=input[i];
				c_freq=1;
			}
			if(c_freq<=2) {
				input[j++]=input[i];
			}
		}
		return j;
	}
}
