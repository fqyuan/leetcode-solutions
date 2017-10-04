class Solution {
    public void rotate(int[][] matrix) {
        tranverse(matrix);
        fliph(matrix);
    }
    private void tranverse(int[][] matrix){
        for(int i = 0; i < matrix.length; i++){
            for(int j = i+1; j < matrix[0].length; j++){
                swap(matrix,i,j,j,i);
            }
        }
    }    
    private void fliph(int[][] matrix){
        for(int i = 0; i < matrix.length; i++){
            int left = 0; int right = matrix[0].length-1;
            while(left < right){
                swap(matrix,i,left++,i,right--);
            }
        }
    }
    private void swap(int[][] matrix, int ai, int aj,int bi,int bj){
        int tmp = matrix[ai][aj];
        matrix[ai][aj] = matrix[bi][bj];
        matrix[bi][bj] = tmp;
    }
    
}