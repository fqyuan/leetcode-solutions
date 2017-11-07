class Solution {

    public int uniquePaths(int m, int n) {
        if(m>n) return uniquePaths(n,m);
        int[] col = new int[m];
        for(int i = 0; i < col.length; i++){
            col[i] = 1;
        }
        for(int i = 1; i < n;i++){
            for(int j= 1; j < m;j++){
                col[j] += col[j-1];
            }
        }
        return col[m-1];
    }
}
/*
class Solution {

    public int uniquePaths(int m, int n) {
	        int N = m + n - 2;
	        int k = m < n? m-1:n-1;
	        double num = 1;
	        double dem = 1;
	        for(int i = k;i >0; i--){
	             num *= N - i + 1;
	            dem *= i;
	        }
	        return (int) (num/dem);
        
    }
}
*/