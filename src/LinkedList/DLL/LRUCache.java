package LinkedList.DLL;

import java.util.HashMap;
import java.util.Map;

class LRUCache {

    Node head,tail;
    Map<Integer,Node> mpp=new HashMap<>();
    int capacity;
    public LRUCache(int capacity) {
        head=new Node(-1,-1);
        tail=new Node(-1,-1);
        head.next=tail;
        tail.prev=head;
        this.capacity=capacity;
    }

    public int get(int key) {
        if(mpp.containsKey(key))
        {
            Node node=mpp.get(key);
            remove(node);
            insert(node);
            return node.value;
        }
        else
            return -1;
    }

    public void put(int key, int value) {
        if(mpp.containsKey(key))
            remove(mpp.get(key));
        if(mpp.size()==capacity)
            remove(tail.prev);
        insert(new Node(key,value));
    }
    private void remove(Node node)
    {
        mpp.remove(node.key);
        node.prev.next=node.next;
        node.next.prev=node.prev;
    }
    private void insert(Node node)
    {
        mpp.put(node.key,node);
        node.next=head.next;
        node.next.prev=node;
        head.next=node;
        node.prev=head;
    }
}
class Node
{
    Node prev,next;
    int key,value;
    Node(int key,int value)
    {
        this.key=key;
        this.value=value;
        this.prev=null;
        this.next=null;
    }
}

