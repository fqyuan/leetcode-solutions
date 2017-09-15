/*
 * [2] Add Two Numbers
 *
 * https://leetcode.com/problems/add-two-numbers
 *
 * algorithms
 * Medium (27.82%)
 * Total Accepted:    341.9K
 * Total Submissions: 1.2M
 * Testcase Example:  '[2,4,3]\n[5,6,4]'
 *
 * You are given two non-empty linked lists representing two non-negative
 * integers. The digits are stored in reverse order and each of their nodes
 * contain a single digit. Add the two numbers and return it as a linked list.
 * 
 * You may assume the two numbers do not contain any leading zero, except the
 * number 0 itself.
 * 
 * 
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        int carry = 0;

        while(l1 != null && l2 != null) {
            int sum = l1.val + l2.val + carry;
            ListNode digt = new ListNode(sum%10);
            carry = sum/10;
            cur.next = digt;
            cur = digt;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l2 != null) {
                int sum =  l2.val +carry;
                ListNode digt = new ListNode(sum%10);
                carry =  sum/10;
                cur.next = digt;
                cur = digt;
                l2 = l2.next;
            }
         while (l1 != null) {
                int sum =  l1.val +carry;
                ListNode digt = new ListNode(sum%10);
                carry =  sum/10;
                cur.next = digt;
                cur = digt;
                l1 = l1.next;
            }
        if (carry != 0) {
            ListNode digt = new ListNode(carry);
            cur.next = digt;
        }
        return dummy.next;
    }
}
