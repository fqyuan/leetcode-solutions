/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
    	// merge sort
    	if(head == null || head.next == null) return head;
        ListNode second = getMid(head);
    	head = sortList(head);
    	second = sortList(second);
    	 
        return merge(head, second);
    }
    
    public ListNode getMid(ListNode head){
    	ListNode fast = head.next, slow = head;
    	while(fast != null && fast.next != null) {
    		slow = slow.next;
    		fast = fast.next.next;
    	}
    	ListNode second = slow.next;
    	 slow.next =  null;
    	return second;
    }
    public ListNode merge(ListNode a, ListNode b) {
    	ListNode dummy = new ListNode(0);
    	ListNode cur = dummy;
    	while(a != null && b != null) {
    		if(a.val < b.val) {
    			cur.next = a;
    			a = a.next;
    		} else {
    			cur.next = b;
    			b = b.next;
    		}
    		cur = cur.next;
    	}
    	if(a == null) 
    		cur.next = b;
    	else 
    		cur.next = a;
    	return dummy.next;
    }
}