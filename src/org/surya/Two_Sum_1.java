package org.surya;

import java.util.Arrays;
import java.util.HashMap;

public class Two_Sum_1 {

	public static void main(String args[]) {
		int[] nums = new int[] {};
		int target = 0;
		System.out.println(new Two_Sum_1().new Solution().twoSum(nums, target));
	}
	
	class Solution {
	    public int[] twoSum(int[] nums, int target) {
	    	int[] twoIndex = new int[2];
	    	
	    	HashMap<Integer, Integer> complementVsIndex = new HashMap<>(); 
	    	
	    	int numsLen = nums.length, complement = 0;;
	    	for(int i=0;i<numsLen;i++) {
	    		complement = target - nums[i];
	    		if(complementVsIndex.containsKey(complement)) {
	    			twoIndex[0] = complementVsIndex.get(complement);
	    			twoIndex[1] = i;
	    			break;
	    		}
	    		complementVsIndex.put(nums[i], i);
	    	}
	    	
	        return twoIndex;
	    }
	}
}
