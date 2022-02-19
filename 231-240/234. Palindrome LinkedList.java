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
    public boolean isPalindrome(ListNode head) {
        if (head==null) return false;
        if(head.next==null) return true;
        ListNode fast = head.next;
        ListNode slow = head;
        
        while(fast !=null && fast.next !=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode newhead = slow.next;
        slow.next = null;
        ListNode beginner = head;
        ListNode reversedList = reversedList(newhead);
        ListNode reverseReference = reversedList;
        
        while (head !=null && reversedList !=null){
            if (head.val != reversedList.val) return false;
            head= head.next;
            reversedList = reversedList.next;
        }
        
        slow.next =reversedList(reverseReference);
        
        return true;
    }
    
    public ListNode reversedList(ListNode curr){
        ListNode prev=null;
        while (curr !=null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev= curr;
            curr = temp;
        }
        
        return prev;
    }
}
