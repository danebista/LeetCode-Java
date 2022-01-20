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
    public ListNode partition(ListNode head, int x) {
        ListNode small = new ListNode(0);
        ListNode big = new ListNode(0);
        ListNode smallDummy = small;
        ListNode bigDummy = big;
        
        while (head!=null){
            if (head.val < x){
                smallDummy.next = head;
                smallDummy = smallDummy.next;
            }  
            else{
                bigDummy.next = head;
                bigDummy = bigDummy.next;
            }
            
            head = head.next;
        }
        smallDummy.next = big.next;
        bigDummy.next = null;
        
        return small.next;
    }
}
