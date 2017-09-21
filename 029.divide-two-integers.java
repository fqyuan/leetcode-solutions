class Solution {
    public int divide(int dividend, int divisor) {
    	if(dividend == 0) return 0; 
    	if(dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;

    	long ab_dividend = Math.abs((long) dividend);
    	long ab_divisor = Math.abs((long) divisor);
    	long res = 0;
    	while(ab_dividend >= ab_divisor) {
    		int dit = 0;
    		while (ab_dividend > ab_divisor << (dit+1)){
    			dit++;
    		}
    		ab_dividend -= ab_divisor << dit;
    		res += 1 << dit;
    	}
        if(dividend > 0 ^ divisor > 0) res = 0 - res;
        if(res < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        if(res > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        return (int) res;
    }
}