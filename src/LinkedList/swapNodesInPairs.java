package LinkedList;

public class swapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy=new ListNode(0,head);
        ListNode prevNode=dummy,currNode=head;

        while(currNode!=null && currNode.next!=null)
        {
            //Save the nextPair
            ListNode nextPair=currNode.next.next;
            //Track the next node
            ListNode nextNode=currNode.next;
            //Reverse the nodes
            currNode.next=nextPair;
            nextNode.next=currNode;
            prevNode.next=nextNode;
            //update th pointers for the next iteration
            prevNode=currNode;
            currNode=nextPair;
        }
        return dummy.next;
    }
}
