package org.surya;

import java.util.Arrays;

public class House_Robber_198 {
	public static void main(String args[]) {
		System.out.println(new House_Robber_198().new Solution().rob(new int[] {2,7,9,3,1}));
	}
	class Solution {
		private static int globalNums[], memo[];
	    public int rob(int[] nums) {
	    	globalNums = nums;
	    	memo = new int[globalNums.length];
	    	Arrays.fill(memo, -1);
	    	return rob(globalNums.length - 1);
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
