import java.io.*;
import java.util.*;
import java.lang.*;
import java.util.function.*;

public class PossibleTriangles {
	public static void main(String[] args) throws IOException {
		BufferedReader reader= new BufferedReader(new InputStreamReader(System.in));
		Integer[] list= (Integer[]) Arrays.stream(reader.readLine().split(" ")).map(new Function<String, Integer>() {
                @Override
                public Integer apply(String s) {
                    return Integer.parseInt(s);
                }
            }).toArray(Integer[]::new);
		Arrays.sort(list,(o1, o2) -> (o1.compareTo(o2)));
		int t=0;
		for (int i=0;i<list.length;) {
			for(int j=i+1;j<list.length;) {
				int k=j+1;
				while(k<list.length && list[i]+list[j]>list[k]) {
					k++;
				}
				t+=(k-j-1);
				j++;				
			}
			i++;
		}
		System.out.println(t);
	}
}
