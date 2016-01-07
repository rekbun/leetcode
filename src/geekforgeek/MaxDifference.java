package geekforgeek;

import java.util.Arrays;
import java.util.Collections;
import java.io.*;
import java.lang.*;

public  class MaxDifference {
 	public static void main(String [] args) throws IOException {
		BufferedReader reader= new BufferedReader(new InputStreamReader(System.in));
		int[] in=Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int max=in[in.length-1];
		int i=in.length-1;
		int v=0;
		while(i>=0) {
			v=Math.max(v,max-in[i]);
			if(in[i]>max) {
				max=in[i];	
			}
			i--;	
		}
		System.out.println(v);
	}

}

