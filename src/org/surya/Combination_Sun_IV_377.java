package org.surya;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Combination_Sun_IV_377 {
	private int dp[];
	public static void main(String[] args) {
		System.out.println(new Combination_Sun_IV_377().new Solution().combinationSum4(new int[] { 2, 3}, 4));
	}
	
	class Solution {
	    private int globalNums[];
	    public int combinationSum4(int[] nums, int target) {
	        globalNums = nums;
	        Arrays.sort(globalNums);
	        dp = new int[target + 1];
	        Arrays.fill(dp, -1);
	        dp[0] = 1;
	        return helper(target);
	    }

	    private int helper(int target) {
	        if (dp[target] != -1) {
	            return dp[target];
	        }
	        int res = 0;
	        for (int i = 0; i < globalNums.length; i++) {
	            if (target < globalNums[i]) {
	                break;
	            }
	            res += helper(target - globalNums[i]);
	        }
	        dp[target] = res;
	        return res;
	    }
	}
}
