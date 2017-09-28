/*
 * [10] Regular Expression Matching
 *
 * https://leetcode.com/problems/regular-expression-matching
 *
 * algorithms
 * Hard (24.11%)
 * Total Accepted:    153.1K
 * Total Submissions: 634.4K
 * Testcase Example:  '"aa"\n"a"'
 *
 * Implement regular expression matching with support for '.' and '*'.
 * 
 * 
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 * 
 * The matching should cover the entire input string (not partial).
 * 
 * The function prototype should be:
 * bool isMatch(const char *s, const char *p)
 * 
 * Some examples:
 * isMatch("aa","a") → false
 * isMatch("aa","aa") → true
 * isMatch("aaa","aa") → false
 * isMatch("aa", "a*") → true
 * isMatch("aa", ".*") → true
 * isMatch("ab", ".*") → true
 * isMatch("aab", "c*a*b") → true
 * 
 */
class Solution {
		enum Result{
			TURE,FALSE
		}
	    char[] s;
	    char[] p;
	    Result[][] res;
	    public boolean isMatch(String s, String p) {
	        this.s = s.toCharArray();
	        this.p = p.toCharArray();
	        res = new Result[this.s.length+1][this.p.length+1];
	        return dp(0, 0);
	    }
	    private boolean dp (int si, int pi) {
	    	if(res[si][pi] != null) return res[si][pi] == Result.TURE;
	    	boolean tmp;
	        if (pi == p.length) 
	        	tmp = si == s.length; // end
	        else {
	  			boolean head_match = si < s.length && (s[si] == p[pi] || p[pi]== '.');
		        
		        if (pi + 1 < p.length && p[pi + 1] == '*') {
		            tmp =  dp(si, pi + 2)||head_match && dp(si + 1, pi) ;// IMPORTANT
		        } else {
		            tmp = head_match && dp(si + 1, pi + 1);
		        }
	        }
	       
	        res[si][pi] = tmp ? Result.TURE : Result.FALSE;
	        return tmp;
	    }
	       
}
