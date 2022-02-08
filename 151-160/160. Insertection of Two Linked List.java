/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

 //Remember when we reach the end of a list, we are not assigning next but setting the head to another list. This helps solve the case of no intersection as null==null.
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA==null || headB==null) return null;
        ListNode a_poi = headA;
        ListNode b_poi = headB;
        
        while (a_poi !=b_poi){
           
            if (a_poi == null){
                a_poi = headB;
            }
            else{
                a_poi = a_poi.next;   
            }
          
            if (b_poi ==null){
                b_poi = headA;
            }
            else{
                b_poi = b_poi.next;   
            }
    
        }
        
        return a_poi;
    }
}
