/*
  http://oj.leetcode.com/problems/gas-station/
 */
public class CompleteCircuit {
	public int canCompleteCircuit(int[] gas, int[] cost) {
		if(gas.length==0) {
			return 0;
		}
		int s=0;
		int cur_gas=gas[0]-cost[0];
		int len=1;
		int i=1;
		while(len<gas.length) {
			if(cur_gas<0) {
				while(cur_gas<0 && (s+gas.length)%gas.length<i%gas.length) {
					cur_gas+=(-gas[s]+cost[s++]);
					len--;
				}
			}
			cur_gas+=(gas[i]-cost[i]);
			i=(i+1)%gas.length;
			len++;
		}
		if(cur_gas<0) {
			return -1;
		}
		return s;
	}
}
