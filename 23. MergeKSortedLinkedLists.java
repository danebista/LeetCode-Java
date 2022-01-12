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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        return divideListsAndMerge(lists, 0, lists.length-1);
    }
    
    public ListNode divideListsAndMerge(ListNode[] lists, int start, int end){
        if (start == end) return lists[start];
        int mid = start + (end-start)/2;
        ListNode left = divideListsAndMerge(lists, start, mid);
        ListNode right = divideListsAndMerge(lists, mid+1, end);
        return merge(left, right);
    }
    
    public ListNode merge(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(-1);
        ListNode l3 = dummy;
        while(l1 !=null && l2!=null){
            if (l1.val< l2.val){
                dummy.next=l1;
                l1=l1.next;
            }
            else{
                dummy.next=l2;
                l2=l2.next;
            }
            dummy=dummy.next;
        }
        if (l1!=null){
            dummy.next=l1;
            dummy=dummy.next;
        }
        
        if(l2!=null){
            dummy.next = l2;
            dummy = dummy.next;
        }
        
        return l3.next;
    }
}
