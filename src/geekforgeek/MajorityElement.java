package geekforgeek;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.io.BufferedReader;
public class MajorityElement {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int nS=Integer.parseInt(reader.readLine());
		int[] array=Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int i=1;
		int cnt=1;

		while(i<array.length) {
			if(array[i]==array[0]) {
				cnt++;
			}
			i++;
		}

		if(cnt==array.length/2) {
			System.out.println(cnt);
		}

		findMajority(array);		
	}

	public static int findMajority(int[] array) {

		int c=1;
		int v=array[1];
		int s=2;

		while(s<array.length) {
			if(array[s]==v) {
				c++;
			}
			else {
				c--;
			}
			if(c==0) {
				v=array[s];
				c=1;
			}
		}
		return v;
		
	}
}
