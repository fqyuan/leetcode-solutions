/*
 * [166] Fraction to Recurring Decimal
 *
 * https://leetcode.com/problems/fraction-to-recurring-decimal
 *
 * algorithms
 * Medium (17.54%)
 * Total Accepted:    54.3K
 * Total Submissions: 309.4K
 * Testcase Example:  '1\n5'
 *
 * Given two integers representing the numerator and denominator of a fraction,
 * return the fraction in string format.
 * 
 * If the fractional part is repeating, enclose the repeating part in
 * parentheses.
 * 
 * For example,
 * 
 * Given numerator = 1, denominator = 2, return "0.5".
 * Given numerator = 2, denominator = 1, return "2".
 * Given numerator = 2, denominator = 3, return "0.(6)".
 * 
 * 
 * 
 * Credits:Special thanks to @Shangrila for adding this problem and creating
 * all test cases.
 */
class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
    	if (numerator == 0) return "0";
    	StringBuilder s = new StringBuilder();
		s.append((numerator > 0) ^ (denominator > 0) ? "-" : "");
		long num = Math.abs((long)numerator);	
        long den = Math.abs((long)denominator);
	        s.append(num/den);        
	        num %= den;

        if (num == 0) return s.toString();
        else s.append(".");

        // Fractional part
        HashMap<Long, Integer> map = new HashMap<Long, Integer>();
        while (num != 0) {
        	if (map.containsKey(num)) {
        		s.insert(map.get(num),"(");
        		s.append(")");
        		break;
        	} 
        	map.put(num, s.length());
        	num *= 10;
        	s.append(num/den);
        	num %= den;
        }

        
        return s.toString();
    }
}
