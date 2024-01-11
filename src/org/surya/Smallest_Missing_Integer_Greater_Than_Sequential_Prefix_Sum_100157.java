package org.surya;

import java.util.Arrays;
import java.util.HashSet;

public class Smallest_Missing_Integer_Greater_Than_Sequential_Prefix_Sum_100157 {
	public static void main(String[] args) {
		System.out.println(new Smallest_Missing_Integer_Greater_Than_Sequential_Prefix_Sum_100157().new Solution().missingInteger(new int[] {1,2,3,2,5}));
	}
	
	class Solution {
	    public int missingInteger(int[] nums) {
	    	
	    	HashSet<Integer> numbers = new HashSet<>();
	    	int max = 0;
	    	for(int num : nums) {
	    		numbers.add(num);
	    		max = Math.max(max, num);
	    	}
	    	
	    	int sum = nums[0], numsLen = nums.length; 
	    	
	    	for(int i=1;i<numsLen;i++) {
	    		if(nums[i] != nums[i-1] + 1 ) {
	    			break;
	    		}
	    		sum += nums[i];
	    	}
	    	
	    	max = Math.max(max, sum);
	    	max++;
	    	
	    	for(int i=sum;i<=max;i++) {
	    		if(!numbers.contains(i)) {
	    			return i;
	    		}
	    	}
	    	
	        return 0;
	    }
	}
}
