package org.surya;

import java.util.Arrays;

public class House_Robber_II_213 {
	public static void main(String args[]) {
		System.out.println(new House_Robber_II_213().new Solution().rob(new int[] {1,7,9,2}));
	}
	
	class Solution {
		private static int globalNums[], memo[];
	    public int rob(int[] nums) {
			globalNums = nums;
			
			if(globalNums.length == 0) {
				return 0;
			}else if(globalNums.length == 1) {
				return globalNums[0];
			}else if(globalNums.length == 2) {
				return Math.max(globalNums[0], globalNums[1]);
			}
			
			
	        memo = new int[globalNums.length];
	        Arrays.fill(memo, -1);
			
	        int temp = globalNums[globalNums.length - 1];
	        globalNums[globalNums.length - 1] = 0;
	        int max = rob(globalNums.length - 1);
	        
	        
	        globalNums[0] = 0;
	        globalNums[globalNums.length - 1] = temp;
	        Arrays.fill(memo, -1);
	        
			max = Math.max(max, rob(globalNums.length - 1));
			
	        return max;
	    }
	    
	    public int rob(int i) {
	        
	        if(i < 0) {
	            return 0;
	        }
	        
	        if(memo[i] != -1) {
	            return memo[i];
	        }
	        
	        memo[i] = Math.max(rob(i-2) + globalNums[i], rob(i-1));
	        
	        return memo[i];
	        
	    }
	}
}
