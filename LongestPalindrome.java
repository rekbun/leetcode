public class Solution {
     int lp[][]=new int[1000][1000];
        
     public String longestPalindrome(String s)
    {
        if(s==null||s.isEmpty()) {
            return s;
        }
        int ei=0;
        String ret=null;
        int si=0;
        for(int len=1;len<=s.length();len++) {
            for(int i=0;i<s.length()-len+1;i++) {
                int j=i+len-1;
                if(len==1) {
                    lp[i][j]=1;
                }else if(len==2) {
                    if(s.charAt(i)==s.charAt(j)) {
                        lp[i][j]=1;
                    }else {
                        lp[i][j]=0;
                    }
                }else {
                    if(s.charAt(i)==s.charAt(j)) {
                        lp[i][j]=lp[i+1][j-1];
                    }else {
                        lp[i][j]=0;
                    }
                }
                if(lp[i][j]==1) {
                    if((ei-si)<(j-i)) {
                        ei=j;
                        si=i;
                    }
                }
            }
        }
        
        return s.substring(si,ei+1);
    }

}
