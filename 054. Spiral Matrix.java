//    c1  ** c2
// r1 * * * * *
// *  *
// *  *
// r2 *       *   
// unread area 
class Solution {
    public List < Integer > spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList();
        if(matrix.length== 0) return ans;
        int r1 = 0; int r2 = matrix.length-1; 
        int c1 = 0; int c2 = matrix[0].length-1;     
        while(r1 <= r2 && c1 <= c2) {      //area is valid
            for(int ci = c1; ci <= c2; ci++) ans.add(matrix[r1][ci]);  // left -> right
            for(int ri = r1 + 1; ri <= r2; ri++) ans.add(matrix[ri][c2]);  // top -> donwn
            if(r1 < r2 && c1 < c2) {    // area is not line, 1 X n or n X 1
                for(int ci = c2 - 1; ci >= c1; ci--) ans.add(matrix[r2][ci]); // left <- right
                for(int ri = r2 - 1; ri >= r1+1; ri--) ans.add(matrix[ri][c1]);  // top <- donwn
            }
            r1++;r2--;
            c1++;c2--;
        }
        return ans;
    }
}