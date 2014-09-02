package leetcode;

public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String src)
    {
        int []lookup= new int[26];
        for(int i=0;i<26;i++) {
            lookup[i]=-1;
        }
        int c_len=0;
        int c_i=0;
        int ret_len=0;
        for(int i=0;i<src.length();i++) {
            int idx=lookup[(src.charAt(i)-'a')];
            if(idx<c_i) {
                c_len++;
            }else if(idx>=c_i) {
              if(ret_len<c_len) {
                  ret_len=c_len;
              }
              c_i=idx+1;
              c_len=i-c_i+1;
            }
            lookup[(src.charAt(i)-'a')]=i;      
          if(ret_len<c_len) {
              ret_len=c_len;
          }
        
          
        }
        return ret_len;
    }
}
