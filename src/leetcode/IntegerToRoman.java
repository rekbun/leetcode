package leetcode;

/*
http://oj.leetcode.com/problems/integer-to-roman/
 */
public class IntegerToRoman {
	public String intToRoman(int num) {
		if(num < 1 || num > 3999) return null;
		int[] value = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
		String[] rom = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
		String rl = "";
		for(int i = 0; i < value.length; i++)
			while(num >= value[i]){
				num -= value[i];
				rl += rom[i];
			}
		return rl;
	}
}
