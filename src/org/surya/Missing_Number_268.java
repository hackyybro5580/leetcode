package org.surya;

public class Missing_Number_268 {
	class Solution {
	    public int missingNumber(int[] nums) {
	        int numsLen = nums.length;
	        int sum = 0;
	        for(int i=0;i<numsLen;i++){
	            sum+=nums[i];
	        }
	        return ((numsLen * (numsLen+1))/2 - sum);
	    }
	}
}
