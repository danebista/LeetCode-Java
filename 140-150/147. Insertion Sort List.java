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
    public ListNode insertionSortList(ListNode head) {
        ListNode start = new ListNode();
        start.next = head;
        ListNode prev = start;
        ListNode current = head;
        
        while (current != null){
            if (current.next !=null && current.next.val< current.val){
                while (prev.next != null && (prev.next.val < current.next.val)) prev = prev.next;
                ListNode temp = prev.next;
                prev.next = current.next;
                current.next = current.next.next;
                prev.next.next = temp;
                prev = start;
                }
            else{
                current = current.next;
            }
        }
        
        return start.next;
    }
}
