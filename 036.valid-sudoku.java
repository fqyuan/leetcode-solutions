class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i = 0; i < 9; i++) {
        	HashSet<Character> rowset = new HashSet<>();
        	HashSet<Character> colset = new HashSet<>();
        	HashSet<Character> cubset = new HashSet<>();
            for(int j = 0; j < 9; j++) {
            	if(board[i][j]!='.' && !rowset.add(board[i][j])) return false;
            	if(board[j][i]!='.' && !colset.add(board[j][i])) return false;
            	int row = 3*(i/3);  // 3X3 cubes
            	int col = 3* (i%3);   // locate which cube is
            	if(board[row+j/3][col+j%3] !='.'&& !cubset.add(board[row+j/3][col+j%3])) return false;
            	
            }
        }
        return true;
    }
}