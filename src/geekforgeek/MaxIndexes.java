import java.io.*;
import java.util.*;
import java.lang.*;

public class MaxIndexes {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int[] inp= Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int [] lMin=new int[inp.length];
		int [] lMax= new int[inp.length];
		lMin[0]=inp[0];
		int i=1;
		for(i=1;i<inp.length;i++) {
			lMin[i]=Math.min(inp[i],lMin[i-1]);
		}
		lMax[inp.length-1]=inp[inp.length-1];
		for(i=inp.length-2;i>=0;i--) {
			lMax[i]=Math.max(inp[i],lMax[i+1]);
		}
		int j=0;
		i=0;
		int max=0;
		while(i<inp.length && j<inp.length) {
			if(lMin[i]>lMax[j]) {
			   i++;
			}else if(lMin[i]<=lMax[j]) {
				max=Math.max(max,j-i);	
				j++;
			}	
		}
		System.out.println(max);
	}

}
