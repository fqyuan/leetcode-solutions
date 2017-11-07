class Solution {
	public boolean exist(char[][] board, String word) {
		char[] w = word.toCharArray();
		boolean ans = false;
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[0].length; j++) {
				 if( helper(board, i, j, w, 0)) return true;
			}
		}
		return ans;
	}
	
	private boolean helper(char[][] board, int i, int j, char[] word, int index) {
		if(index == word.length) return true;
		if(i < 0 || i >= board.length || j < 0 || j >= board[0].length) return false;
		if(board[i][j] != word[index]) return false;
		int t = (int) board[i][j];
		board[i][j] ^= 256;
		t = (int) board[i][j];
		boolean res = helper(board, i + 1, j, word, index + 1)||
					  helper(board, i - 1, j, word, index + 1)||
					  helper(board, i, j + 1, word, index + 1)||
					  helper(board, i, j - 1, word, index + 1);
		board[i][j] ^= 256;
		return res;
	}
	    
}