public class Solution {
	 char[] c;
	    public int myAtoi(String str) {
	        if (str.isEmpty()) return 0;
	         c = str.toCharArray();
	        int i = 0;
	        while(c[i] == ' '){
	            i++;
	            if (i >= c.length) return 0;
	        }
	        if (c[i] >= '0' && c[i] <= '9' ){
	            int l = i;
	           int r = find(l);
	            return calculate(l,r,true);
	        } else if (c[i] == '+' || c[i] == '-') {
	            if (i == c.length - 1) return 0;
	            if (c[i+1] >= '0' && c[i+1] <= '9' ){
	                int l = i + 1;
	               int  r = find(l);
	                if(c[i] == '+')
	                    return calculate(l,r,true);
	                else
	                    return calculate(l,r,false);
	            } else return 0;
	        }else 
	            return 0;
	            
	    }
	    private int find(int l){
	                    int r = l +1;
	            while( r < c.length) {
	                if (c[r] >= '0' && c[r] <= '9') r++;
	                else break;
	            }
	            return r - 1;
	    }
	    private int calculate (int l, int r, boolean sign){
	         long sum = 0;
	            if (sign) {
	                while(r >= l) {
	                sum = 10*sum + c[l++] - '0';
	                if(sum > Integer.MAX_VALUE) return Integer.MAX_VALUE;
	                }
	            } else {
	                while(r >= l) {
	                sum = 10*sum - (c[l++] - '0');
	                if(sum < Integer.MIN_VALUE) return Integer.MIN_VALUE;
	                }
	            }
	        return (int) sum;
	    }
}