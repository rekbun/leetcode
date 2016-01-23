package geekforgeek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Arrays;

public class MZeroes {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] array= Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n=Integer.parseInt(reader.readLine());
        int nz=0;
        int i=0;
        for(i=0;i<array.length && nz<n;i++) {
            if(array[i]==0) {
              nz++;
            }
        }
        int max=i;
        int j=i;
        while(i<array.length) {
            if(array[i]==0) {
                while (array[j]!=0) {
                    j++;
                }
            }
            i++;

            max=Math.max(max,i-j+1);
        }

        System.out.println(max);
    }
}
