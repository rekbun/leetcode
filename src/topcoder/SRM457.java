package topcoder;

/**
 * Created by rakesh.singh on 01/09/14.
 */
public class SRM457 {
    public static class TheSquareDivTwo {
        public String[] solve(String[] board) {
            int[] rl = parse(board);
            int[] cl = new int[rl.length];
            String[] transpose = new String[board.length];

            for(int i=0;i<board.length;i++) {
                transpose[i]="";
            }
            for (int i = 0; i < board.length; i++) {

                int j = 0;
                for (j = board.length-1; j >= 0 && rl[i]-- > 0; j--) {
                    transpose[j] += 'C';
                }
                while (j-- >= 0) {
                    transpose[j+1] += '.';
                }
            }
            return transpose;

        }

        private int[] parse(String[] board) {
            int[] ret = new int[board.length];
            for (int r = 0; r < board.length; r++) {
                for (int c = 0; c < board[r].length(); c++) {
                    ret[r] += board[r].charAt(c) == '.' ? 0 : 1;
                }
            }
            return ret;
        }
    }

    public static void main(String[] args) {
        String[] src = new String[]{"C.C..C.C..C..C.",
                "CCC...C..CCC.C.",
                "......CC...CCCC",
                ".C..CC.C.C.C.C.",
                "C....C.C......C",
                ".....C..CCCCC.C",
                "CCC.......CCCCC",
                "..C.C..C.C...C.",
                "CCC....CCC.CC..",
                "CC.CCCC.CCCC...",
                ".C..C.CC.C.CC.C",
                "C.CCCC..CC..C.C",
                ".CCCC.CCCCCC...",
                "..C...C.CCC.CC.",
                "CCCC..CCC.C...."};
        String[] sol = new TheSquareDivTwo().solve(src);
    }
}
