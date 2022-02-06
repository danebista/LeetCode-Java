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
    public ListNode sortList(ListNode head) {
        if (head==null || head.next == null) return head;
        
        ListNode left = head;
        ListNode right = getMid(head);
        ListNode temp = right.next;
        right.next = null;
        right = temp;
        
        left = sortList(left);
        right = sortList(right);
        
        return merge(left, right);
        
    }
    
    public ListNode getMid(ListNode head){
        ListNode slow = head;
        ListNode fast = head.next;
        
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow;
    }
    
    public ListNode merge(ListNode l1, ListNode l2){
        ListNode l3 = new ListNode();
        ListNode dummy = l3;
        
        while (l1!=null && l2!=null){
            if (l1.val<l2.val){
                l3.next = l1;
                l1 = l1.next;
            }
            else{
                l3.next = l2;
                l2 = l2.next;
            }
            l3 = l3.next;
        }
        
        if (l1!=null){
            l3.next = l1;
            l3 = l3.next;
        }
        
        if (l2!=null){
            l3.next = l2;
            l3 = l3.next;
        }
        
        return dummy.next;
    }
}
