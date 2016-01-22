package geekforgeek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MinSwaps {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] array = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] maps = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < maps.length; ) {
            map.put(maps[i], maps[i + 1]);
            i += 2;
        }
        System.out.println(swapUtil(array, map, 0));
    }

    private static int swapUtil(int[] array, Map<Integer, Integer> map, int i) {
        if (i >= array.length) {
            return 0;
        }
        if (map.getOrDefault(array[i], -1) == array[i + 1] || map.getOrDefault(array[i + 1], -1) == array[i]) {
            return swapUtil(array, map, i + 2);
        }
        int a = find(array, i, array[i + 1]);
        int swap = array[i + 1];
        array[i + 1] = a;
        array[a] = swap;
        int l = swapUtil(array, map, i + 2);
        swap = array[i + 1];
        array[i + 1] = a;
        array[a] = swap;
        a = find(array, i, array[i + 1]);
        swap = array[i + 1];
        array[i + 1] = a;
        array[a] = swap;
        int r = swapUtil(array, map, i + 2);
        swap = array[i + 1];
        array[i + 1] = a;
        array[a] = swap;
        return 1 + Math.min(l, r);
    }

    private static int find(int[] array, int i, int e) {
        for (int j = i; j < array.length; j++) {
            if (array[j] == e) {
                return array[j];
            }
        }
        return -1;
    }
    
}
