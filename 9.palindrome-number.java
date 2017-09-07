/*
 * [9] Palindrome Number
 *
 * https://leetcode.com/problems/palindrome-number
 *
 * algorithms
 * Easy (35.38%)
 * Total Accepted:    240.8K
 * Total Submissions: 680.8K
 * Testcase Example:  '-2147483648'
 *
 * Determine whether an integer is a palindrome. Do this without extra space.
 * 
 * click to show spoilers.
 * 
 * Some hints:
 * 
 * Could negative integers be palindromes? (ie, -1)
 * 
 * If you are thinking of converting the integer to string, note the
 * restriction of using extra space.
 * 
 * You could also try reversing an integer. However, if you have solved the
 * problem "Reverse Integer", you know that the reversed integer might
 * overflow. How would you handle such case?
 * 
 * There is a more generic way of solving this problem.
 * 
 * 
 */
class Solution {
    public boolean isPalindrome(int x) {
    	if (x < 0 || (x!=0 && x%10 == 0)) return false;
        int revert = 0;
        while(x > revert) {
        	
        	revert = 10 * revert +  x % 10;
        	x /= 10; 
        }
        return ( revert == x || revert / 10 == x);
        
    }
}
