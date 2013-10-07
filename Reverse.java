public class Solution {
    public int reverse(int x) {
       int y=0;
       int sign=1;
       if(x<0) {
           x=x*-1;
           sign=-1;
       }
        while(x>0) {
            y=y*10+x%10;
            x=x/10;
        }
        return sign*y;   
    }
}
