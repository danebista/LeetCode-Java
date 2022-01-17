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
    public ListNode rotateRight(ListNode head, int k) {
       if (head == null || k==0) return head;
       int count = 1;
       ListNode dummy = head;
        
     
      while(dummy.next!=null){
          count+=1;
          dummy=dummy.next;
      }
        
      int movements = k % count;
      if (movements ==0) return head;
      
      ListNode current = head;
      for(int i=0; i<count-movements-1;i++){
          current=current.next;
      }
      ListNode newHead = current.next;
      current.next = null;
      dummy.next= head;
      
      return newHead;
    }
}
