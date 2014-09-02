package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/*

 */
public class SurrounderRegions {
	public void solve(char[][] board) {
		if (board.length == 0) {
			return;
		}

		for (int i = 0; i < board.length; i++) {
			solveUtil(board, i, 0);
		}
		for (int i = 0; i < board[0].length; i++) {
			solveUtil(board, 0, i);
		}
		for (int i = 0; i < board.length; i++) {
			solveUtil(board, i, board[0].length - 1);
		}
		for (int i = 0; i < board[0].length; i++) {
			solveUtil(board, board.length - 1, i);
		}

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == 'O') {
					board[i][j] = 'X';
				}
				if (board[i][j] == '#') {
					board[i][j] = 'O';
				}
			}
		}
	}

	public void solveUtilRec(char[][] board, int row, int col) {
		if ((row < 0) || (col < 0) || (row >= board.length) || (col >= board[0].length)) {
			return;
		}

		if (board[row][col] == 'X' || board[row][col] == 'N') {
			return;
		}
		if (board[row][col] == 'O') {
			board[row][col] = 'N';
		}
		solveUtil(board, row + 1, col);
		solveUtil(board, row, col + 1);
		solveUtil(board, row, col - 1);
		solveUtil(board, row - 1, col);
	}

	class Pair {
		int r, c;

		public Pair(int row, int col) {
			r = row;
			c = col;
		}
	}

	public void solveUtil(char[][] board, int row, int col) {
		if ((row < 0) || (col < 0) || (row >= board.length) || (col >= board[0].length)) {
			return;
		}

		if (board[row][col] == 'X' || board[row][col] == '#') {
			return;
		}

		Queue<Pair> q = new LinkedList<Pair>();
		q.add(new Pair(row, col));
		board[row][col] = '#';
		while (!q.isEmpty()) {
			Pair p = q.remove();
			int i = p.r;
			int j = p.c;
			if (i - 1 >= 0 && board[i - 1][j] == 'O') {
				board[i - 1][j] = '#';
				q.add(new Pair(i - 1, j));
			}
			if (j + 1 < board[0].length && board[i][j + 1] == 'O') {
				board[i][j + 1] = '#';
				q.add(new Pair(i, j + 1));
			}
			if (i + 1 < board.length && board[i + 1][j] == 'O') {
				board[i + 1][j] = '#';
				q.add(new Pair(i + 1, j));
			}
			if (j - 1 >= 0 && board[i][j - 1] == 'O') {
				board[i][j - 1] = '#';
				q.add(new Pair(i, j - 1));
			}
		}

	}
}
