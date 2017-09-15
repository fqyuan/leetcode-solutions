/*
 * [70] Climbing Stairs
 *
 * https://leetcode.com/problems/climbing-stairs
 *
 * algorithms
 * Easy (40.11%)
 * Total Accepted:    190.8K
 * Total Submissions: 475.6K
 * Testcase Example:  '1'
 *
 * You are climbing a stair case. It takes n steps to reach to the top.
 * 
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can
 * you climb to the top?
 * 
 * 
 * Note: Given n will be a positive integer.
 * 
 */
class Solution {
    public int climbStairs(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        int one_step_before = 2;
        int two_step_befort = 1;
        int current = 0;
        for (int i = 3; i <= n; i++) {
        	current = one_step_before + two_step_befort;
        	two_step_befort = one_step_before;
        	one_step_before = current;
        }
        return current;
    }
}
