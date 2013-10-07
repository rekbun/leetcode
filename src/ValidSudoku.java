import java.util.HashMap;

public class ValidSudoku {
    private boolean check(char[] chars) {
		HashMap<Character,Integer> map= new HashMap<Character, Integer>();
		for(int i=0;i<chars.length;i++) {
			if(chars[i]=='.') {
			    continue;
			} 
			if(map.containsKey(chars[i])) {
				return false;
			}else {
				map.put(chars[i],1);
			}
		}
		return true;
	}
	private boolean check(char[][] board, int idx) {
		HashMap<Character,Integer> map= new HashMap<Character, Integer>();
		for(int i=0;i<board.length;i++) {
			if(board[i][idx]=='.') {
			    continue;
			}
			if(map.containsKey(board[i][idx])) {
				return false;
			}else {
				map.put(board[i][idx],1);
			}
		}
		return true;
	}
	private boolean check(char[][] board, int s, int e ) {
		HashMap<Character,Integer> map= new HashMap<Character, Integer>();
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				if(board[i+s][j+e]=='.') {
				    continue;
				}
				if(map.containsKey(board[i+s][j+e])) {
					return false;
				}else {
					map.put(board[i+s][j+e],1);
				}
			}
		}
		return true;
	
	}

	public boolean isValidSudoku(char[][] board) {
		for(int i=0;i<board.length;i++) {
			if(check(board[i])) {
				continue;
			}else {
				return false;
			}
		}
		for(int i=0;i<board.length;i++) {
			if(check(board,i)) {
				continue;
			}else {
				return false;
			}
		}

		for(int i=0;i<board.length;i+=3) {
			for(int j=0;j<board.length;j+=3) {
				if(check(board,i,j)) {
					continue;
				}else {
					return false;
				}
			}
		}
		return true;
	}
}
