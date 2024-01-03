package org.surya;

import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Coin_Change_322 {

	public static void main(String[] args) {
		System.out.println(new Coin_Change_322().new Solution().coinChange(new int[] {1,2,5}, 11));
	}
	
	class Solution {
	    public int minCoinCount = 0;
	    public boolean isFound = false;
	    public int coinChange(int[] coins, int amount) {
	        int bottomUp[] = new int[amount+1];
	        Arrays.fill(bottomUp, amount+1);
	        bottomUp[0] = 0;
	        
	        for(int i=1;i<=amount;i++){

	            for(int coin : coins){
	                if(i >= coin){
	                    bottomUp[i] = Math.min(bottomUp[i-coin] + 1, bottomUp[i]);
	                }
	            }

	        }
	        
	        return bottomUp[amount] == amount+1 ? -1 : bottomUp[amount];
	        
	    }
	    
	}
}
