/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
   public ListNode mergeKLists(ListNode[] lists) {
       if(lists != null && lists.length == 0) return null;
        PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length, new Comparator<ListNode>(){
        	@Override
        	public int compare(ListNode node1, ListNode node2){
        		if (node1.val < node2.val) return -1;
        		if (node1.val > node2.val) return 1;
        		return 0;
        	}
        }); 
        for (ListNode e : lists) {
            if(e != null ) pq.add(e);
        }
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while(!pq.isEmpty()) {
        	ListNode tmp = pq.remove();
        	cur.next = new ListNode(tmp.val);
        	cur = cur.next;
        	if(tmp.next != null) pq.add(tmp.next);
        }
        return dummy.next;
    }
}