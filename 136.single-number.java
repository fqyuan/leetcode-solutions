/*
 * [136] Single Number
 *
 * https://leetcode.com/problems/single-number
 *
 * algorithms
 * Easy (54.53%)
 * Total Accepted:    235.3K
 * Total Submissions: 431.5K
 * Testcase Example:  '[1]'
 *
 * Given an array of integers, every element appears twice except for one. Find
 * that single one.
 * 
 * 
 * Note:
 * Your algorithm should have a linear runtime complexity. Could you implement
 * it without using extra memory?
 * 
 */
class Solution {
    public int singleNumber(int[] nums) {
    	int res = 0;
        for (int e : nums) {
        	res ^= e;
        }
        return res;
    }
}
