/*
 * [3] Longest Substring Without Repeating Characters
 *
 * https://leetcode.com/problems/longest-substring-without-repeating-characters
 *
 * algorithms
 * Medium (24.37%)
 * Total Accepted:    342.8K
 * Total Submissions: 1.4M
 * Testcase Example:  '"abcabcbb"'
 *
 * Given a string, find the length of the longest substring without repeating
 * characters.
 * 
 * Examples:
 * 
 * Given "abcabcbb", the answer is "abc", which the length is 3.
 * 
 * Given "bbbbb", the answer is "b", with the length of 1.
 * 
 * Given "pwwkew", the answer is "wke", with the length of 3. Note that the
 * answer must be a substring, "pwke" is a subsequence and not a substring.
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        int max = 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
       int begin = 0;
       int end = 0;
        for (; end < s.length(); end++) {
            if (map.containsKey(s.charAt(end))) {    
                begin = Math.max(map.get(s.charAt(end))+1, begin);
                
            } 
            max = Math.max(max, end - begin + 1);
            map.put(s.charAt(end), end);
        }
        return max;
    }
}