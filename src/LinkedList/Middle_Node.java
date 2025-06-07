package LinkedList;

public class Middle_Node {
    static Node head;
    private Node middleNode()
    {
        if(head==null )
            return null;
        Node slow=head;
        Node fast=head;
        while(fast!=null && fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
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
    public static void main(String[] args) {
        head=new Node(1);
        head.next=new Node(2);
        head.next.next=new Node(3);
        head.next.next.next=new Node(4);
        head.next.next.next.next=new Node(5);
        System.out.println("DynamicProgramming.Test case 1: ");
        display();
        Node middle=new Middle_Node().middleNode();
        System.out.println("Middle Node of the LL: "+middle.data);
        head.next.next.next.next.next=new Node(6);
        display();
        middle=new Middle_Node().middleNode();
        System.out.println("Middle Node of the LL:"+middle.data);
    }
}
