/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        ListNode prev = dummy;
        ListNode curr = head;
        
        while(curr != null && curr.next != null){
            ListNode p = curr.next.next;
            ListNode q = curr.next;
            q.next = curr;
            curr.next = p;
            prev.next = q;
            
            prev =curr;
            curr = p;
        }
        
        return dummy.next;
        
    }
}
