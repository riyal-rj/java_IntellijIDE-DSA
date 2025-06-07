package LinkedList;

class LL_Scratch {
    static private class Node
    {
        int data;
        Node next;
        Node(int data)
        {
            this.data=data;
            this.next=null;
        }
        Node(int data,Node next)
        {
            this.data=data;
            this.next=next;
        }
    }

    static Node head;
    static int size;
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
    static void insertAtBeginning(int value)
    {
        if(head==null)//For empty list
        {
            head=new Node(value);
            size++;
            return;
        }
        Node node=new Node(value,head);
        head=node;
        size++;
    }
    static void insertAtEnd(int value)
    {
        if(head==null)
        {
            head=new Node(value);
            size++;
            return;
        }
        Node node=new Node(value);
        Node temp=head;
        while(temp.next!=null)
        {
            temp=temp.next;
        }
        temp.next=node;
        size++;
    }
    static Node search(int value)
    {
        if(head==null)
            return null;
        Node temp=head;
        while(temp!=null)
        {
            if(temp.data==value)
                break;
            temp=temp.next;
        }
        return temp;
    }
    static void insertBefore(int value,int before)
    {
        if(head==null)
        {
            System.out.println("Not possible");
            return;
        }
        Node temp=head;
        while(temp.next.data!=before)
            temp=temp.next;

        Node node=new Node(value,search(before));
        temp.next=node;
        size++;
    }
    static void insertAfter(int value,int after)
    {
        if(head==null)
        {
            System.out.println("Not possible");
            return;
        }
        Node temp=search(after);
        Node next=temp.next;
        Node node =new Node(value);
        temp.next=node;
        node.next=next;
        size++;
    }

    static Node find(int pos)
    {
        Node temp=head;
        int i=1;
        while(i<pos)
        {
            temp=temp.next;
            i++;
        }
        return temp;
    }

    static void insertAt(int value,int pos)
    {
        if(head==null || pos-1==0){
            insertAtBeginning(value);
            return;
        }
        if(pos-1==size)
        {
            insertAtEnd(value);
            return;
        }
        Node get=find(pos-1);
        Node next=get.next;
        Node node=new Node(value,next);
        get.next=node;
        size++;
    }
    static int index;
    private static boolean findKey(int key)
    {
        if(head==null)
            return false;
        else if (head.data==key){
            index =1;
            return true;}
        else
        {
            Node temp=head;
            while(temp!=null)
            {
                index++;
                if(temp.data==key)
                    return true;
                temp=temp.next;
            }
            return false;
        }

    }
    private static int top()
    {
        if(head==null)
            return Integer.MIN_VALUE;
        else
            return head.data;
    }

    private static void deleteBeginning()
    {
        if(head==null)
        {
            System.out.println("No items to delete!!");
            return;
        }
        int pop=head.data;
        head=head.next;
        System.out.println("Popped element is: "+pop);
        size--;
    }

    private static void deleteEnd()
    {
        if(head==null)
        {
            System.out.println("No items to delete!!");
            return;
        }
        Node temp=head;
        Node last=null;
        while(temp.next!=null) {
            last=temp;
            temp = temp.next;
        }
        last.next=null;

        int pop=temp.data;
        System.out.println("Popped element is : "+pop);
        size--;
    }

    private static void deletePos(int pos)
    {
        Node before=find(pos-1);
        Node after=find(pos+1);
        Node pop=find(pos);
        System.out.println("Popped Element is : "+pop.data);
        before.next=after;
        size--;
    }

    private static void deleteVal(int value)
    {
        Node got=search(value);
        System.out.println("Popped Element is: "+got.data);
        Node temp=head;
        while(temp.next.data!=value)
            temp=temp.next;
        temp.next=got.next;
        size--;

    }


    private static void reverse()
    {
        if(head==null)
            return;

        Node prev=null;
        Node node=head;
        while(node!=null)
        {
            Node temp=node.next;
            node.next=prev;
            prev=node;
            node=temp;
        }
        head=prev;

    }
    public static void main(String[] args) {
        insertAtBeginning(30);
        insertAtBeginning(20);
        insertAtBeginning(10);
        insertAtEnd(40);
        insertAtEnd(50);
        insertAtBeginning(5);
        insertBefore(45,30);
        insertAfter(67,40);
        insertAfter(29,20);
        display();
        System.out.println("Top of tyhe list: "+top());
        System.out.println("************");
        insertAt(101,3);
        display();
        insertAt(123,1);
        display();
        insertAt(144,size+1);
        display();
        insertAt(432,7);
        display();
        System.out.println("Size of the List: "+size);
        if(findKey(144))
            System.out.println("Present at "+index);
        else
            System.out.println("Absent!");

        System.out.println("Top of the list: "+top());

        deleteBeginning();
        display();
        deleteBeginning();
        display();
        deleteEnd();
        display();
        deleteEnd();
        display();
        deletePos(5);
        display();
        deleteVal(30);
        display();
        System.out.println(size);
        reverse();
        display();
    }
}
