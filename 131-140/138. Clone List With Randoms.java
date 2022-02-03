/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node current = head;
        if (current == null) return  null;
        
        while(current !=null){
            Node temp = current.next;
            current.next = new Node(current.val);
            current.next.next  = temp;
            current = temp;
        }
        
        current = head;
        
        while(current !=null && current.next !=null){
            current.next.random = (current.random !=null)?
                current.random.next:null;
            
            current=current.next.next;
        }
        
        Node original = head;
        Node copy=head.next;
        Node returnable = copy;
        
        while(original !=null && copy !=null){
           
            original.next = (original.next != null) ? original.next.next : original.next;
            copy.next = (copy.next != null) ? copy.next.next : copy.next;
            original = original.next;
            copy = copy.next;
        }
        
        return returnable;
        
    }
}
