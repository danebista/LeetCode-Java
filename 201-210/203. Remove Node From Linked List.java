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
    public ListNode removeElements(ListNode head, int val) {
        if (head == null)return head;
        ListNode prev = new ListNode(0, head);
        
        while (head!=null && head.val==val){
            head=head.next;
        }
        
        ListNode curr = head;
        while (curr !=null){
            if (curr.val == val){
                while(curr!=null && curr.val== val){
                    curr = curr.next;
                }
                prev.next = curr;
            }
            else{
                prev = curr;
                curr = curr.next;
            }
        }
        
        return head;
    }
}
