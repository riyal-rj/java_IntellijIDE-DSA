package LinkedList;

import java.util.LinkedList;

class Rotate_LL {
    static private class Node
    {
        int data;
        Node next;
        Node(int data)
        {
            this.data=data;
            this.next=null;
        }
    }
    static Node head;
    public Node rotateRight(int k)
    {
        if(head==null || head.next==null)
            return head;

        Node temp=head;
        int len=1;
        while(temp.next!=null)
        {
            len++;
            temp=temp.next;
        }
        System.out.println(len);
        k=k%len;

        if(k==0)
            return head;
        temp.next=head;
        Node newLast=findNthNode(len-k);
        System.out.println(newLast.data);
        head=newLast.next;
        newLast.next=null;
        return head;
    }
    static void display()
    {
        if(head==null)
        {
            System.out.println("Empty Linked List!");
            return;
        }
        Node temp=head;
        while(temp!=null)
        {
            System.out.print(temp.data+"-->");
            temp=temp.next;
        }
        System.out.println("NULL");

    }
    Node findNthNode(int n)
    {
        if(n==0)
            return head;
        int i=1;
        Node temp=head;
        while(i<n)
        {
            temp=temp.next;
            i++;
        }
        return temp;
    }

    public static void main(String[] args) {
        head=new Node(1);
        head.next=new Node(2);
        head.next.next=new Node(3);
        head.next.next.next=new Node(4);
        head.next.next.next.next=new Node(5);
        System.out.println("DynamicProgramming.Test case 1: ");
        Rotate_LL rl=new Rotate_LL();
        System.out.println("Before: ");
        display();
        rl.rotateRight(2);
        System.out.println("After: ");
        display();
        rl=null;
        System.out.println("DynamicProgramming.Test case 2: ");
        Rotate_LL rl1=new Rotate_LL();
        head=new Node(0);
        head.next=new Node(1);
        head.next.next=new Node(2);
        System.out.println("Before: ");
        display();
        rl1.rotateRight(4);
        System.out.println("After: ");
        display();
    }
}
