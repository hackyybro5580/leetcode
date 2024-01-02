package org.surya;

public class Reverse_Bits_190 {
	
	public static void main(String args[]) {
		System.out.println(new Reverse_Bits_190().new Solution().reverseBits(-3));
	}
	
	public class Solution {
	    // you need treat n as an unsigned value
	    public int reverseBits(int n) {
	        if(n == 0 )
	            return 0;
	        
	        
	        int reversedNum = 0;
	        
	        if(n < 0) {
	            for(int i=0;i<32;i++) {
	                reversedNum <<= 1;
	                reversedNum += ((n&1) == 1) ? 1 : 0;
	                n>>=1;
	                
	            }
	        }else {
	            int leftShiftCount = 0;
	            while(n != 0) {
	                leftShiftCount++;
	                reversedNum <<= 1;
	                reversedNum += ((n&1) == 1) ? 1 : 0;
	                n>>=1;
	                
	            }
	            
	            reversedNum = reversedNum << 32 - leftShiftCount;
	        }
	        
	        return reversedNum;
	    }
	}
}
