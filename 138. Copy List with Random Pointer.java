/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null) return null;
        HashMap<RandomListNode, RandomListNode> set = new HashMap<>();
        RandomListNode copy = new RandomListNode(head.label);
        set.put(head, copy);
        RandomListNode copyHead = copy;
        RandomListNode old = head;
        while(old.next != null) {
            copy.next = new RandomListNode(old.next.label);
            set.put(old.next, copy.next);
            copy = copy.next;
            old = old.next;
        }
        copy = copyHead;
        while(head != null) {
            copy.random = set.get(head.random);
            head = head.next;
            copy = copy.next;
        }
        return copyHead;
    }
    
    /*
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null) return null;
        HashMap<RandomListNode, RandomListNode> set = new HashMap<>();
        RandomListNode copy = new RandomListNode(head.label);
        set.put(head, copy);
        RandomListNode copyHead = copy;
        RandomListNode old = head;
        while(old.next != null) {
            copy.next = new RandomListNode(old.next.label);
            set.put(old.next, copy.next);
            copy = copy.next;
            old = old.next;
        }
        copy = copyHead;
        while(head != null) {
            copy.random = set.get(head.random);
            head = head.next;
            copy = copy.next;
        }
        return copyHead;
    }
    */
    /* stack overflow
    public RandomListNode copyRandomList(RandomListNode head) {
        HashMap<RandomListNode, RandomListNode> set = new HashMap<>();
        return copyHelper(head,set);
    }
    public RandomListNode copyHelper(RandomListNode old, HashMap<RandomListNode, RandomListNode> set){
        if(old == null) return null;
        if(set.containsKey(old)){
            return set.get(old);
        }
        RandomListNode copy = new RandomListNode(old.label);
        set.put(old, copy);
        copy.next = copyHelper(old.next,set);
        copy.random = copyHelper(old.random,set);
        return copy;
    }
    */
}