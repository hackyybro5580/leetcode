package org.surya;

import java.util.Stack;

public class Container_With_Most_Water_11 {

	public static void main(String[] args) {
		int[] height = new int[] {1,8,6,2,5,4,8,3,7};
		System.out.println(new Container_With_Most_Water_11().new Solution().maxArea(height));
	}
	
	class Solution {
	    public int maxArea(int[] height) {
	    	int maxArea = 0;
	    	int i=0;
	    	int j=height.length -1;
	    	while(i<j) {
	    		maxArea = Math.max(maxArea, (j - i) * Math.min(height[i], height[j]));
	    		
	    		if(height[i] < height[j]) {
	    			i++;
	    		}else {
	    			j--;
	    		}
	    	}
	    	
	    	return maxArea;
	    }
	}
}
