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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l3 = new ListNode(0);
        ListNode dummy = l3;
        int carry = 0;
        while( l1!= null || l2 != null){
            int a = l1 != null ? l1.val : 0;
            int b = l2 != null ? l2.val : 0;
            int sum = a + b + carry;
            int val = sum % 10;
            carry = sum / 10;
            
            l3.next = new ListNode(val);
            
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
            l3 = l3.next;
        }
        
        if (carry != 0){
            l3.next = new ListNode(carry);
            l3 = l3.next;
        }
        
        return dummy.next;
    }
}