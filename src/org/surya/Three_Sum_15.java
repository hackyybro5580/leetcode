package org.surya;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;
import java.util.stream.Collectors;

public class Three_Sum_15 {

	public static void main(String args[]) {
		int[] nums = new int[] {-1,0,1,2,-1,-4};
		System.out.println(new Three_Sum_15().new Solution().threeSum(nums));
	}
	
	class Solution {
	    public static List<List<Integer>> threeSum(int[] nums) {
	        if (nums.length < 3) {
	            return Collections.emptyList();
	        }
	        Set<List<Integer>> uniqueElements = new HashSet<>();
	        List<Integer> numberList = new ArrayList<>();
	        Arrays.sort(nums);
	        for(int i=0, j, k;i<nums.length -2;i++) {

	            if (i > 0 && nums[i] == nums[i - 1]) {
	                continue;
	            }
	            
	            j = i+1;
	            k = nums.length-1;
	            
	            while(k > j) {
	                if((nums[i] + nums[j] + nums[k]) == 0) {
	                    numberList = Arrays.asList(nums[i], nums[j], nums[k]);
	                    uniqueElements.add(numberList);
	                    j++;
	                    k--;
	                }else if((nums[i] + nums[j] + nums[k]) > 0) {
	                    k--;
	                }else {
	                    j++;
	                }
	            }
	            
	            
	        }
	        
	        return uniqueElements.stream().collect(Collectors.toList());
	    }
	}
}
