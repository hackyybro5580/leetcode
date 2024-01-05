package org.surya;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Word_Break_139 {
	
	public static void main(String[] args) {
		System.out.println(new Word_Break_139().new Solution().wordBreak("leetcode", Arrays.asList("leet","code","sand","and","cat")));
	}
	
	class Solution {
		
	    public boolean wordBreak(String s, List<String> wordDict) {
	    	boolean[] dp = new boolean[s.length() + 1];
	        Set<String> set = new HashSet<>(wordDict);

	        dp[0] = true;
	        for (int i = 1; i <= s.length(); i++) {
	            for (int j = 0; j<i; j++) {
	                dp[i] = dp[j] && set.contains(s.substring(j, i));
	                if(dp[i]) break;
	            }
	        }
	        return dp[s.length()];
	    }
	    
	}
}
