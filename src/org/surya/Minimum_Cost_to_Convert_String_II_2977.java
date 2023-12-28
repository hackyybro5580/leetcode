package org.surya;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Minimum_Cost_to_Convert_String_II_2977 {

	
	public static void main(String args[]) {
		Solution sol = new Minimum_Cost_to_Convert_String_II_2977().new Solution();
		
		
		
		String source = "jegbx";
		String target = "ezhfc";
		String[] original = new String[] {"egbx","hrbf","twne","snjd","ysrf","qzqg","rcll","ekvz","inpr","frxs","xcww","unsw","vdug","ycvs","j","v","j","y","n","q","w","a","z","g","b","d"};
		String[] changed = new String[] {"hrbf","twne","snjd","ysrf","qzqg","rcll","ekvz","inpr","frxs","xcww","unsw","vdug","ycvs","zhfc","v","j","y","n","q","w","a","z","g","b","d","e"};
		int[] cost = new int[] {50682,89150,91153,85032,97960,96862,81138,86570,77628,45200,44955,70845,99254,80325,91331,95349,84374,94177,53994,94284,79531,92353,60384,100000,93152,19787};
		
		System.out.println(sol.minimumCost(source, target, original, changed, cost));
	}

	
	
	public class Solution {
		
		public long minimumCost(String source, String target, String[] original, String[] changed, int[] cost) {
	        
			
			int changedLen = changed.length;
			HashMap<String, Integer> keyVsIndexMap = new HashMap<>();
	    	int indexVal = 0;
	    	for(int i=0;i<changedLen;i++) {
	    		if(!keyVsIndexMap.containsKey(original[i])) {
	    			keyVsIndexMap.put(original[i], indexVal++);
	    		}
	    		if(!keyVsIndexMap.containsKey(changed[i])) {
	    			keyVsIndexMap.put(changed[i], indexVal++);
	    		}
	    		
	    	}
	    	
	    	changedLen = keyVsIndexMap.size();
	    	long dis[][] = new long[changedLen][changedLen];
	    	
	    	for(int i=0;i<changedLen;i++) {
	    		Arrays.fill(dis[i], Long.MAX_VALUE);
	    		dis[i][i] = 0;
	    	}
	    	
	    	
	    	int costLen = cost.length; 
	    	for(int i=0;i<costLen;i++) {
	    		dis[keyVsIndexMap.get(original[i])][keyVsIndexMap.get(changed[i])] = Math.min(dis[keyVsIndexMap.get(original[i])][keyVsIndexMap.get(changed[i])], cost[i]);
	    	}
	    	
	    	for(int k=0;k<changedLen;k++)
	    	{
		    	for(int i=0;i<changedLen;i++) {
		    		
		    		if(dis[i][k] < Long.MAX_VALUE) {
		    			
		    			for(int j=0;j<changedLen;j++) {
		    				
		    				if(dis[k][j] < Long.MAX_VALUE) {
		    					dis[i][j] = Math.min(dis[i][j], dis[i][k] + dis[k][j]);
		    				}
			    		}
		    		}
		    	}
	    	}
	    	
	    	HashSet<Integer> set = new HashSet<>();
	        for (String o : original) {
	            set.add(o.length());
	        }
	        long[] dp = new long[target.length() + 1];
	        Arrays.fill(dp, Long.MAX_VALUE);
	        dp[0] = 0L;
	        for (int i = 0; i < target.length(); i++) {
	            if (dp[i] == Long.MAX_VALUE) {
	                continue;
	            }
	            if (target.charAt(i) == source.charAt(i)) {
	                dp[i + 1] = Math.min(dp[i + 1], dp[i]);
	            }
	            for (int t : set) {
	                if (i + t >= dp.length) {
	                    continue;
	                }
	                int c1 = keyVsIndexMap.getOrDefault(source.substring(i, i + t), -1);
	                int c2 = keyVsIndexMap.getOrDefault(target.substring(i, i + t), -1);
	                if (c1 >= 0 && c2 >= 0 && dis[c1][c2] < Long.MAX_VALUE) {
	                    dp[i + t] = Math.min(dp[i + t], dp[i] + dis[c1][c2]);
	                }
	            }
	        }
	        return dp[dp.length - 1] == Long.MAX_VALUE ? -1L : dp[dp.length - 1];
	    }
	}
	
}