/**
 * Created with IntelliJ IDEA.
 * User: rakeshkumar
 * Date: 10/26/13
 * Time: 7:26 PM
 * To change this template use File | Settings | File Templates.
 */
enum Input_Type {

}
public class ValidNumber {
	boolean isNumber(String num) {
		 int INVALID=0;    // 0
		 int SPACE=1,      // 1
			SIGN=2,       // 2
			DIGIT=3,      // 3
			DOT=4,        // 4
			EXPONENT=5,   // 5
			NUM_INPUTS=6 ;// 6

		int[][] transitionTable =new int[][] {
			{-1,  0,  3,  1,  2, -1},     // next states for state 0
			{-1,  8, -1,  1,  4,  5},     // next states for state 1
			{-1, -1, -1,  4, -1, -1},     // next states for state 2
			{-1, -1, -1,  1,  2, -1},     // next states for state 3
			{-1,  8, -1,  4, -1,  5},     // next states for state 4
			{-1, -1,  6,  7, -1, -1},     // next states for state 5
			{-1, -1, -1,  7, -1, -1},     // next states for state 6
			{-1,  8, -1,  7, -1, -1},     // next states for state 7
			{-1,  8, -1, -1, -1, -1},     // next states for state 8
		};

		int state = 0;
		int i=0;
		while (i <num.length()) {
			int inputType = INVALID;
			if (num.charAt(i)==' ')
			inputType = SPACE;
			else if (num.charAt(i) == '+' || num.charAt(i) == '-')
			inputType = SIGN;
			else if (num.charAt(i)>='0'&& num.charAt(i)<='9')
			inputType = DIGIT;
			else if (num.charAt(i) == '.')
			inputType = DOT;
			else if (num.charAt(i) == 'e' || num.charAt(i) == 'E')
			inputType = EXPONENT;

			// Get next state from current state and input symbol
			state = transitionTable[state][inputType];

			// Invalid input
			if (state == -1) return false;
			else i++;
		}
// If the current state belongs to one of the accepting (final) states,
// then the number is valid
		return state == 1 || state == 4 || state == 7 || state == 8;

	}
}
