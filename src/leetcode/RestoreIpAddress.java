package leetcode;

import java.util.ArrayList;

/*
http://oj.leetcode.com/problems/restore-ip-addresses/
 */
public class RestoreIpAddress {
	public ArrayList<String> restoreIpAddresses(String src) {
		if(src.length()==0) {
			return new ArrayList<String>();
		}

		return restoreIpAddressUtil(src, 4);
	}

	private ArrayList<String> restoreIpAddressUtil(String src, int periods) {
		ArrayList<String> ret= new ArrayList<String>();

		if(src.length()<periods|| src.length()>periods*3) {
			return ret;
		}
		if(periods==1) {
			if((src.length()==2 && Integer.parseInt(src.substring(0,2))<9)||(src.length()==3 && Integer.parseInt(src.substring(0,3))<99)) {

			} else if(Integer.parseInt(src)<=255) {
				ret.add(src);
			}
			return ret;
		}

		for(int i=1;i<=3&& i<src.length();i++) {
			if((i==2 && Integer.parseInt(src.substring(0,i))<=9)||(i==3 && (Integer.parseInt(src.substring(0,i))<=99 || Integer.parseInt(src.substring(0,i))>255 ))) {
				continue;
			}
			for(String ans:restoreIpAddressUtil(src.substring(i), periods-1)) {
				ret.add(src.substring(0,i)+"."+ans);
			}
		}

		return ret;

	}
}
