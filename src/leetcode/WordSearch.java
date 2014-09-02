package leetcode; /*
 * http://oj.leetcode.com/problems/word-search/
 * */

public class WordSearch {
	public boolean exist(char[][] board,String keyword) {
		if(board.length==0) {
			return false;
		}

		boolean [][] checked=new boolean[board.length][board[0].length];
		for(int i=0;i<board.length;i++) {
			for(int j=0;j<board[0].length;j++) {
				if(existUtil(board,keyword,0,checked,i,j)) {
					return true;
				}

			}
		}
		return false;
	}

	private boolean existUtil(char[][] board, String keyword, int s, boolean[][] checked, int cs, int ce) {
		if(s==keyword.length()) {
			return true;
		}

		if(cs<0 || ce<0 || cs>=board.length|| ce>=board[0].length) {
			return false;
		}


		if(checked[cs][ce]) {
			return false;
		}

		if(board[cs][ce]==keyword.charAt(s)) {
			checked[cs][ce]=true;
			if(existUtil(board, keyword, s+1, checked, cs+1, ce)||
					existUtil(board, keyword, s+1, checked, cs-1, ce)||
					existUtil(board, keyword, s+1, checked, cs, ce+1)||
					existUtil(board, keyword, s+1, checked, cs, ce-1)) {
				return true;
			}
			checked[cs][ce]=false;

		}
		return false;

	}
}
