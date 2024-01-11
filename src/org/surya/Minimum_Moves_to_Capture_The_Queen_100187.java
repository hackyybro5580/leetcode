package org.surya;

public class Minimum_Moves_to_Capture_The_Queen_100187 {
	
	public static void main (String[] args) {
		System.out.println(new Minimum_Moves_to_Capture_The_Queen_100187().new Solution().minMovesToCaptureTheQueen(1, 1, 1, 4, 1, 8));
	}
	
	class Solution {
	    public int minMovesToCaptureTheQueen(int a, int b, int c, int d, int e, int f) {

	    	a--;
	    	b--;
	    	c--;
	    	d--;
	    	e--;
	    	f--;
	    	
	    	int chess[][] = new int[8][8];
	    	chess[a][b] = 1;	//elephant
	    	chess[c][d] = 2;	//bishop
	    	chess[e][f] = 3;	//black queen
	    	
	    	int moves = 2;
	    	
	    	//Bishop check
	    	moves = bishopCheck(chess, c, d) ? 1 : moves;
	    	
	    	if(moves == 1) {
	    		return moves;
	    	}
	    	
	    	
	    	//Elephant check
	    	moves = elephantCheck(chess, a, b) ? 1 : moves;
	    	
	    	
	    	return moves;
	    }
	    
	    public static boolean bishopCheck(int[][] chess, int currentRow, int currentCol) {
	    	
	    	int col = currentCol, row = currentRow;
	    	//To topleft
	    	while(col>=0 && row>=0) {
	    		
	    		if(chess[row][col] == 3) {
					return true;
				}else if(chess[row][col] == 1) {
					break;
				}
	    		
	    		row--;
	    		col--;
	    	}
	    	
	    	
	    	col = currentCol;
	    	row = currentRow;
	    	//To topright
	    	while(col<8 && row>=0) {
	    		
	    		if(chess[row][col] == 3) {
					return true;
				}else if(chess[row][col] == 1) {
					break;
				}
	    		
	    		row--;
	    		col++;
	    	}
	    	
	    	
	    	col = currentCol;
	    	row = currentRow;
	    	//To bottomleft
	    	while(col>=0 && row<8) {
	    		
	    		if(chess[row][col] == 3) {
					return true;
				}else if(chess[row][col] == 1) {
					break;
				}
	    		
	    		row++;
	    		col--;
	    	}
	    	
	    	col = currentCol;
	    	row = currentRow;
	    	//To bottomright
	    	while(col<8 && row<8) {
	    		
	    		if(chess[row][col] == 3) {
					return true;
				}else if(chess[row][col] == 1) {
					break;
				}
	    		
	    		row++;
	    		col++;
	    	}
	    	
	    	return false;
	    }
	    
	    public static boolean elephantCheck(int[][] chess, int row, int col) {
	    	
	    	//Top to Down
	    	for(int i=row;i<8;i++) {
				if(chess[i][col] == 3) {
					return true;
				}else if(chess[i][col] == 2) {
					break;
				}
	    	}
	    	
	    	//Left to Right
	    	for(int i=col;i<8;i++) {
	    		if(chess[row][i] == 3) {
					return true;
				}else if(chess[row][i] == 2) {
					break;
				}
	    	}
	    	
	    	//Right to Left
	    	for(int i=col;i>=0;i--) {
	    		if(chess[row][i] == 3) {
					return true;
				}else if(chess[row][i] == 2) {
					break;
				}
	    	}
	    	
	    	//Bottom to Top
	    	for(int i=row;i>=0;i--) {
	    		if(chess[i][col] == 3) {
					return true;
				}else if(chess[i][col] == 2) {
					break;
				}
	    	}
	    	
	    	return false;
	    }
	}
}
