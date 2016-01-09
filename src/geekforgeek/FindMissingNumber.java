import java.io.*;
import java.lang.*;
import java.util.*;

public class FindMissingNumber {

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader= new BufferedReader(new InputStreamReader(System.in));
		int [] inp= Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int s=0;
		int e=inp.length-1;
		while(s<=e) {
			int mid=s+(e-s)/2;
			if(inp[mid]==mid) {
				s=mid+1;
			}else if(inp[mid]>mid) {
				e=mid;
			}else {
				s=mid+1;
			}
				
					
		}
		if(s<inp.length) {
		 System.out.println(s+" "+inp[s]);
		}	
	}	
}
