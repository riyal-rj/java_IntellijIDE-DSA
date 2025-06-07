package LinkedList.Leetcode;

import LinkedList.ListNode;

public class partitionList {
    public static void main(String[] args) {

    }
    public ListNode partition(ListNode head, int x) {
        ListNode minList=new ListNode(0);
        ListNode lTail=minList;
        ListNode maxList=new ListNode(0);
        ListNode rTail=maxList;
        ListNode temp=head;
        while(temp!=null)
        {
            if(temp.val<x)
            {
                lTail.next=temp;
                lTail=lTail.next;
            }
            else
            {
                rTail.next=temp;
                rTail=rTail.next;
            }
            temp=temp.next;
        }
        lTail.next=maxList.next;
        rTail.next=null;
        return minList.next;

    }
}
