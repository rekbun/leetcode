public class Convert {
   public String convert(String s, int nRows) {
        String[] sr=new String[nRows];
        for(int i=0;i<nRows;i++) {
            sr[i]=new String();
        }
        if(nRows==1) {
            return s;
        }
        int d=0;
        int cnt=0;
        for(int i=0;i<s.length();) {
            if(d==0 && cnt<nRows) {
                sr[cnt]+=s.charAt(i);
                cnt++;
                i++;
                if(cnt==nRows) {
                    d=1;
                    cnt=nRows-2;
                    if(cnt==0) {
                        d=0;
                    }
                }
            }else if(d==1 && cnt>0) {
                sr[cnt]+=s.charAt(i);
                cnt--;
                i++;
                if(cnt==0) {
                    d=0;
                }
            }
        }
        String str=new String();
        for(int i=0;i<nRows;i++) {
            if(str.isEmpty()) {
                str=sr[i];
            }else {
                str=str.concat(sr[i]);
            }
        }
        return str;
    }

}
