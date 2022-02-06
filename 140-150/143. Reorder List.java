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
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        
        while(fast !=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        
        ListNode curr = slow.next;
        ListNode prev = null;
        slow.next = null;
        
        while (curr != null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        
        curr = head;
        
        while(prev != null){
            ListNode temp1 = curr.next;
            ListNode temp2 = prev.next;
            curr.next = prev;
            prev.next = temp1;
            curr = temp1;
            prev = temp2;
        }
    }
}
