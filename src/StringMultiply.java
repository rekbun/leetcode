/**
 * Created with IntelliJ IDEA.
 * User: rakeshkumar
 * Date: 10/22/13
 * Time: 8:55 AM
 * To change this template use File | Settings | File Templates.
 */
public class StringMultiply {
	public String multiply(String num1,String num2)  {
		String ans="";
		if(num1.length()>num2.length()) {
			String numc=num1;
			num1=num2;
			num2=numc;
		}
		for(int i=num1.length()-1;i>=0;i--) {
			//multiply
			String tns="";
			int c=0;
			for(int j=num2.length()-1;j>=0;j--) {
				int val=c+Integer.parseInt(String.valueOf(num1.charAt(i)))*(Integer.parseInt(String.valueOf(num2.charAt(j))));
				tns=(val%10)+tns;
				c=(val/10);
			}
			if(c>0){
				tns=c+tns;
			}
			//add
			if(ans=="") {
				ans=tns;
			}else {
				c=0;
				String tAns="";
				for(int xi=i;xi<num1.length()-1;xi++) {
					tns+="0";
				}
				for(int x=tns.length()-1,j=ans.length()-1;x>=0;j--,x--) {
					int ts=0;
					if(j>=0) {
						ts=c+Integer.parseInt(String.valueOf(ans.charAt(j)))+Integer.parseInt(String.valueOf(tns.charAt(x)));
					}
					else {
						ts=c+Integer.parseInt(String.valueOf(tns.charAt(x)));
					}

					tAns=ts%10+tAns;
					c=ts/10;
				}
				if(c>0) {
					tAns=c+tAns;
				}
				ans=tAns;
			}
		}
		for(int i=0;i<ans.length();i++) {
			if(ans.charAt(i)=='0') {
				return "0";
			}else {
				break;
			}

		}
		return ans;
	}
}