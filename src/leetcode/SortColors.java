package leetcode;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created with IntelliJ IDEA.
 * User: rakeshkumar
 * Date: 10/31/13
 * Time: 11:24 AM
 * To change this template use File | Settings | File Templates.
 */
public class SortColors {
	public void sortColors(int[] src) {
		if(src==null|| src.length==0) {
			return;
		}

		int s=-1;
		int e=src.length;
		for(int i=0;i<e&&e>0;) {
			if(src[i]==0) {
				swap(src,++s,i);
				i++;
			}else if(src[i]==2) {
				swap(src,--e,i);
			}else {
				i++;
			}
		}
	}

	private void swap(int[] src, int s, int i) {
		int el=src[s];
		src[s]=src[i];
		src[i]=el;
	}


}
