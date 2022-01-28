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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode prev= new ListNode(-9, head);
        ListNode curr = head;
        
        for (int i=1; i<left;i++){
            curr = curr.next;
            prev = prev.next;
            right--;
        }
        ListNode connection = prev;
        ListNode tail = curr;
        
        while(right!=0){
            ListNode next = curr.next;
            curr.next = prev;
            prev=curr;
            curr=next;
            right--;
        }
        if (connection.val!=-9){
            connection.next = prev;
        }
        else{
            head=prev;
        }
        
        if (tail!=null){
            tail.next=curr;
        }
        
        return head;
    
    }
}
