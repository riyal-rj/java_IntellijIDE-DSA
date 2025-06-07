package LinkedList;

public class Detect_Loop {
    static Node head;
    boolean detectLoop()
    {
        Node slow=head;
        Node fast=head;
        while(fast!=null && fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast)
                return true;

        }
        return false;
    }

    public static void main(String[] args) {
        head=new Node(1);
        head.next=new Node(2);


        head.next.next=new Node(3);
        System.out.println(head.next.next.data);
        System.out.println(head.next.next);
        head.next.next.next=new Node(4);
        head.next.next.next.next=new Node(5);
        head.next.next.next.next.next=new Node(6);
        head.next.next.next.next.next.next=new Node(7);
        head.next.next.next.next.next.next.next=new Node(8);
        Detect_Loop dl=new Detect_Loop();

        head.next.next.next.next.next.next.next.next=new Node(9,head.next.next);
        if(dl.detectLoop())
            System.out.println("Loop is present!");
        else
            System.out.println("Loop is Absent!");

    }
}
