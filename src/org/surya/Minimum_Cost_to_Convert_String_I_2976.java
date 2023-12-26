package org.surya;

public class Minimum_Cost_to_Convert_String_I_2976 {

	//Floyd Warshall's Algorithm - Minimum path from one vertex to another
	
	
}

class Solution {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        
    	int dis[][] = new int[26][26];
    	
    	for(int i=0;i<26;i++) {
    		for(int j=0;j<26;j++) {
    			dis[i][j] = Integer.MAX_VALUE;
    		}
    		dis[i][i] = 0;
    	}
    	
    	int costLen = cost.length; 
    	for(int i=0;i<costLen;i++) {
    		dis[original[i] - 'a'][changed[i] - 'a'] = cost[i];
    	}
    	
    	for(int k=0;k<26;k++)
    	{
	    	for(int i=0;i<26;i++) {
	    		
	    		if(dis[i][k] < Integer.MAX_VALUE) {
	    			
	    			for(int j=0;j<26;j++) {
	    				
	    				if(dis[k][j] < Integer.MAX_VALUE) {
	    					dis[i][j] = Math.min(dis[i][j], dis[i][k] + dis[k][j]);
	    				}
		    		}
	    		}
	    	}
    	}
    	
    	int sourceLen = source.length();
    	long totalCost = 0;
    	for(int i=0;i<sourceLen;i++) {
    		if(dis[source.charAt(i) - 'a'][target.charAt(i) - 'a'] == Integer.MAX_VALUE) {
    			return -1;
    		}
    		totalCost = totalCost + dis[source.charAt(i) - 'a'][target.charAt(i) - 'a'];
    	}
    	
    	return totalCost;
    }
}


