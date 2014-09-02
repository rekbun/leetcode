package leetcode;

import java.util.*;
public class TwoSum {
    public int[] twoSum(int[] numbers ,int k)
    {
        Dictionary<Integer,Integer> dictionary=new Hashtable<Integer, Integer>();
        for(int i=0;i<numbers.length;i++) {
            if(dictionary.get(k-numbers[i])!=null) {
                int[] ret= new int[2];
                ret[0]= dictionary.get(k-numbers[i])+1;
                ret[1]=i+1;
                return ret;
            }else {
                dictionary.put(numbers[i],i);
            }
        }
        return null;
    }
}
