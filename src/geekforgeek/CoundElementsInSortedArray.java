package geekforgeek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CoundElementsInSortedArray {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] list = Arrays.stream(bufferedReader.readLine().split(",")).mapToInt(Integer::parseInt).toArray();

        System.out.print(search(list, 0, list.length - 1));
    }

    private static int search(int[] list, int s, int e) {

        while (s < e) {
            int mid = s + (e - s) / 2;
            if (list[mid] == 1) {
                s = mid + 1;
            } else {
                e = mid;
            }
        }
        return list.length - s;
    }
}
