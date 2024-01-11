package org.surya;

public class Maximum_Area_of_Longest_Diagonal_Rectangle_3000 {
	class Solution {
	    public int areaOfMaxDiagonal(int[][] dimensions) {

	    	int index = 0, dimLen = dimensions.length, result = 0;
	        
            if(dimLen == 1){
                return dimensions[0][0]*dimensions[0][1];
            }
        
	    	double prev = 0, diagonalLen = -1;
	    	for(int i=0;i<dimLen;i++) {
	    		
	    		prev = Math.sqrt((dimensions[i][0] * dimensions[i][0]) + (dimensions[i][1] * dimensions[i][1]));
	    		if(prev > diagonalLen) {
	    			diagonalLen = prev;
	    			result = dimensions[i][0]*dimensions[i][1];
	    		}else if(prev == diagonalLen) {
	    			diagonalLen = prev;
	    			result = Math.max(result, dimensions[i][0]*dimensions[i][1]);
	    		}
	    	}
	    	return result;
	    }
	}
}
