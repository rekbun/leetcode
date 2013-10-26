/**
 * Created with IntelliJ IDEA.
 * User: rakeshkumar
 * Date: 10/25/13
 * Time: 7:44 PM
 * To change this template use File | Settings | File Templates.
 */
public class GenerateMatrix {
	public int[][] generateMatrix(int n) {
		int[][] sm=new int[n][n];
		int rs=0,re=n-1;
		int cs=0;
		int ce=n-1;
		int val=1;
		while(true) {
			if(rs<=re) {
				for(int i=cs;i<=ce;i++) {
					sm[rs][i]=val++;
				}
				rs++;
				if(cs<=ce) {
					for(int i=rs;i<=re;i++) {
						sm[i][ce]=val++;
					}
				}
				ce--;
				if(rs<=re) {
					for(int i=ce;i>=cs;i--) {
						sm[re][i]=val++;
					}
				}
				re--;
				if(cs<=ce) {
					for(int i=re;i>=rs;i--) {
						sm[i][cs]=val++;
					}
				}
				cs++;

				if(rs<re ||cs<ce) {
					break;
				}
			}
		}
		return sm;
	}
	public static void main(String[] args) {
		GenerateMatrix sol= new GenerateMatrix();
		sol.generateMatrix(5);
	}
}
