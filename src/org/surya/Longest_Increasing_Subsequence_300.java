package org.surya;

import java.util.Arrays;

public class Longest_Increasing_Subsequence_300 {
	
	public static void main(String[] args) {
		int[] nums = new int[] {0,1,0,3,2,3};
		System.out.println(new Longest_Increasing_Subsequence_300().new Solution().lengthOfLIS(nums));
	}
	
	class Solution {
	    public int lengthOfLIS(int[] nums) {
	    	int maxLen = 1, numsLen = nums.length;
	    	int[] lenArr = new int[numsLen];
	    	Arrays.fill(lenArr, 1);
	    	
	    	for(int i=0;i<numsLen;i++) {
	    		lenArr[i] = 1;
	    		for(int j=0;j<i;j++) {
	    			if(nums[j] < nums[i]) {
	    				lenArr[i] = Math.max(lenArr[i] , lenArr[j] + 1);
	    				maxLen = Math.max(maxLen, lenArr[i]);
	    			}
	    		}
	    	}
	    	return maxLen;
	    }
	}	
}
