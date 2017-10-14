class Solution {
    public void solve(char[][] board) {
        if(board.length == 0) return;
        for(int i = 0; i < board.length; i++){
            if(board[i][0] == 'O') {
                board[i][0] = '1';
                spread(i, 0, board);
            }
            if(board[i][board[0].length - 1] == 'O') {
                board[i][board[0].length - 1] = '1';
                spread(i, board[0].length - 1, board);
            }
        }
        for(int i = 1; i < board[0].length - 1; i++){
            if(board[0][i] == 'O') {
                board[0][i] = '1';
                spread(0, i, board);
            }
            if(board[board.length - 1][i] == 'O') {
                board[board.length - 1][i] = '1';
                spread( board.length - 1, i, board);
            }
        }
        for(int i = 0; i < board.length; i++){
        	for(int j = 0; j < board[0].length; j++) {
                if(board[i][j] == 'O') board[i][j] = 'X';
                else if(board[i][j] == '1') board[i][j] = 'O';
        	}

        }
    }
    public void spread(int i, int j, char[][] board){
        if(i < board.length - 2 && board[i + 1][j] == 'O') {
            board[i + 1][j] = '1';
            spread(i + 1, j, board);
        }
        if(j < board[0].length - 2 && board[i][j + 1] == 'O'){
            board[i][j + 1] = '1';
            spread(i, j + 1, board);
        }
        if(i > 1 && board[i - 1][j] == 'O') {
            board[i - 1][j] = '1';
            spread(i - 1, j, board);
        }
        if(j > 1 && board[i][j - 1] == 'O'){
            board[i][j - 1] = '1';
            spread(i, j - 1, board);
        }
    }
	
}