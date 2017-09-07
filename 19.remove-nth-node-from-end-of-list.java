/*
 * [19] Remove Nth Node From End of List
 *
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list
 *
 * algorithms
 * Medium (33.58%)
 * Total Accepted:    192.3K
 * Total Submissions: 572.6K
 * Testcase Example:  '[1]\n1'
 *
 * Given a linked list, remove the nth node from the end of list and return its
 * head.
 * 
 * 
 * For example,
 * 
 * 
 * ⁠  Given linked list: 1->2->3->4->5, and n = 2.
 * 
 * ⁠  After removing the second node from the end, the linked list becomes
 * 1->2->3->5.
 * 
 * 
 * 
 * Note:
 * Given n will always be valid.
 * Try to do this in one pass.
 * 
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
	    public ListNode removeNthFromEnd(ListNode head, int n) {
	    	ListNode dummy = new ListNode(0);
	    	dummy.next = head;
	    	ListNode first = dummy;
	    	ListNode second = dummy;
	    	for (int i = 0; i < n + 1; i++ ){
	    		first = first.next;
	    	}
	    	while(first != null) {
	    		first.next;
	    		second.next;
	    	}
	    	second.next = second.next.next;
	    	return dummy.next;
	    }

}
