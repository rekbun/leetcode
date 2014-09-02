package leetcode;

public class Atoi {
        public int atoi(String str) {
                int i=0;
                if(str==null|| str.isEmpty()) {
                        return 0;
                }else {
                        String temp=str.trim();
                        int sign =1;
                        int ret=0;
                        
                        if(temp==null || temp.isEmpty()) {
                                return 0;
                        }else {
                                if(temp.charAt(i)=='+') {
                                        sign=1;
                                        i++;
                                }
                                else if(temp.charAt(i)=='-') {
                                        sign=-1;
                                        i++;
                                }
                                while(temp.charAt(i)=='0') {
                                    i++;
                                }
                                for(int j=i;j<temp.length();j++) {
                                        if(temp.charAt(j)>='0' && temp.charAt(j)<='9') {
                                                ret=ret*10+(temp.charAt(j)-'0');
                                                if(j-i>=9 && sign<0) {
                                                    if(j-i==9) {
                                                        if(str.substring(i,j+1).compareTo("2147483648")>=0) {
                                                            return java.lang.Integer.MIN_VALUE;
                                                        }
                                                    }else {
                                                            return java.lang.Integer.MIN_VALUE;
                                                    }
                                                }else if(j-i>=9 && sign>0) {
                                                    if(j-i==9) {
                                                        if(str.substring(i,j+1).compareTo("2147483648")>=0) {
                                                            return java.lang.Integer.MAX_VALUE;
                                                        }
                                                    }else {
                                                        return java.lang.Integer.MAX_VALUE;
                                                    }
                                                }
                                                
                                                
                                        }else { 
                                                break;
                                        }

                                }
                        }
                        return sign*ret;
                }
                

        }

}
