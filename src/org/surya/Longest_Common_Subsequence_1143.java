package org.surya;

public class Longest_Common_Subsequence_1143 {
	public static void main(String[] args) {
		System.out.println(new Longest_Common_Subsequence_1143().new Solution().longestCommonSubsequence("bsbininm", "jmjkbkjkv"));
	}
	
	class Solution {
	    public int longestCommonSubsequence(String text1, String text2) {
	        int text1Len = text1.length();
	        int text2Len = text2.length();
	        int[][] matrix = new int[text1Len+1][text2Len+1];
	        
	        for(int i=0;i<text1Len;i++) {
	            for(int j=0;j<text2Len;j++) {
	                if(text1.charAt(i) == text2.charAt(j)) {
	                    matrix[i+1][j+1] = matrix[i][j] + 1; 
	                }else {
	                    matrix[i+1][j+1] = Math.max(matrix[i+1][j], matrix[i][j+1]);
	                }
	            }
	        }
	        
	        return matrix[text1Len][text2Len];
	    }
	}
}
