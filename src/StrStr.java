public class StrStr {
   	public String strStr(String haystack,String needle) {
		if(haystack==null || needle==null)  {
			return null;
		}
		if(haystack.length()==0|| needle.length()==0) {
		    if(haystack.length()>0) {
		        return haystack;
		    }else if(needle.length()>0){
		        return null;
		    }else {
		        return "";
		    }
		    
		}
		for(int i=0;i<haystack.length()-needle.length()+1;i++) {
			for(int j=0;j<needle.length();)  {
				if(haystack.charAt(j+i)==needle.charAt(j))  {
					j++;
				}else {
				    break;
				}
				if(j==needle.length()) {
					return haystack.substring(i);
				}

			}
		}
		return null;
	}

}
