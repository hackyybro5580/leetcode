package org.surya;

public class Counting_Bits_338 {

	public static void main(String args[]) {
		System.out.println(new Counting_Bits_338().new Solution().countBits(2));
	}
	
	class Solution {
	    public int[] countBits(int n) {
	    	int[] response = new int[n+1];
	    	for(int i=0;i<=n;i++) {
	    		response[i] = countNumberOf1s(i);
	    	}
	    	return response;
	    }
	    
	    public int countNumberOf1s(int num) {
	    	int numberOf1s = 0;
	    	
	    	while(num != 0) {
	    		numberOf1s += ((num&1) == 1 ? 1 : 0);
	    		num >>= 1;
	    	}
	    	
	    	return numberOf1s;
	    }
	}
}
