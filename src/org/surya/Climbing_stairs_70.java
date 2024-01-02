package org.surya;

public class Climbing_stairs_70 {

	public static void main(String[] args) {
		System.out.println(new Climbing_stairs_70().new Solution().climbStairs(3));
	}
	
	class Solution {
	    public int climbStairs(int n) {
	    	if(n == 0 || n == 1) {
	    		return 1;
	    	}
	    	int prev = 1, curr = 1, temp;
	    	while(n-->=2) {
	    		temp = curr;
	    		curr = prev + curr;
	    		prev = temp;
	    	}
	        return curr;
	    }
	}
}
