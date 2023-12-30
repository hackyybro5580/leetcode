package org.surya;

public class Sum_of_Two_Integers_371 {

	public static void main(String args[]) {
		System.out.println(new Sum_of_Two_Integers_371().new Solution().getSum(2, 3));
	}
	
	public class Solution {
		public int getSum(int a, int b) {
			int c = 0;
			
			while(b != 0) {
				c = a&b;
				a = a^b;
				b = c << 1;
			}
			
	        return a;
	    }
	}
}
