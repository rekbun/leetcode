package leetcode;

/**
 * Created with IntelliJ IDEA.
 * User: rakeshkumar
 * Date: 10/27/13
 * Time: 12:32 PM
 * To change this template use File | Settings | File Templates.
 */
enum InputType {
	INVALID(0),
	SLASH(1),
	CHAR_SEQUENCE(2),
	DOT(3);
	int value;
	InputType(int value) {
		this.value=value;
	}
	InputType() {

	}
	public int getValue() {
		 return value;
	}
 }
public class SimplifyPaths {
	public String simplifyPath(String path) {
		int[][] stateTable=new int[][]{
				{-1,1,-1,-1},
				{-1,1,2,3},
				{-1,1,2,2},
				{-1,5,2,4},
				{-1,1,-1,-1},
				{-1,1,-1,-1},
		};

		int state=0;
		String ret="";

		for(int i=0;i<path.length();i++) {
			InputType inputType;
			if(path.charAt(i)=='.') {
				inputType=InputType.DOT;
			}else if(path.charAt(i)=='/') {
				inputType=InputType.SLASH;
			}else {
				inputType=InputType.CHAR_SEQUENCE;
			}
			int prev=state;
			state=stateTable[state][inputType.getValue()];
			if(prev==state&& state==1) {
				continue;
			}
			ret+=path.charAt(i);

			if(state==-1) {
				return "/";
			}else if(state==5) {
				ret=ret.substring(0,ret.length()-2);
				state=1;

			}else if(state==4) {
				int cn=0;
				if(ret.length()==3) {
					ret="";
				}
				for(int j=ret.length()-1;j>=0;j--) {
					if(ret.charAt(j)=='/') {
						cn++;
					}
					if(cn==2) {
						ret=ret.substring(0,j+1);
						break;
					}
				}
				state=1;
			}
			if(ret=="") {
				ret="/";
			}
		}
		if(state==3) {
			ret=ret.substring(0,ret.length()-2);
		}
		if(state==1&&ret.length()>1) {
			ret=ret.substring(0,ret.length()-1);
		}
		if(ret.isEmpty()) {
			ret="/";
		}

		return ret;
	}
}
