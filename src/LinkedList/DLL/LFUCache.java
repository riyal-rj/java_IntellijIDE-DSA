package LinkedList.DLL;

import java.util.HashMap;
import java.util.Map;

public class LFUCache {

    final int capacity;
    int currSize;
    int minFreq;
    Map<Integer, Node> cache;
    Map<Integer,DoubleLinkedList> freqMap;
    public LFUCache(int capacity)
    {
        this.capacity=capacity;
        this.minFreq=0;
        this.currSize=0;
        this.cache=new HashMap<>();
        this.freqMap=new HashMap<>();
    }
    public int get(int key)
    {
        Node currNode=cache.get(key);
        if(currNode==null)
            return -1;
        updateNode(currNode);
        return currNode.value;
    }
    public void put(int key,int value)
    {
        if(capacity==0)
            return;
        if(cache.containsKey(key))
        {
            Node currNode=cache.get(key);
            currNode.value=value;
            updateNode(currNode);
        }
        else
        {
            currSize++;
            if(currSize>capacity)
            {
                DoubleLinkedList minFreqList=freqMap.get(minFreq);
                cache.remove(minFreqList.tail.prev.key);
                minFreqList.removeNode(minFreqList.tail.prev);
                currSize--;
            }
            minFreq=1;
            Node newNode=new Node(key,value);
            DoubleLinkedList currList=freqMap.getOrDefault(1,new DoubleLinkedList());
            currList.addNode(newNode);
            freqMap.put(1,currList);
            cache.put(key,newNode);
        }
    }
    public void updateNode(Node node)
    {
        int currFreq=node.freq;
        DoubleLinkedList currList=freqMap.get(currFreq);
        currList.removeNode(node);
        if(currFreq== minFreq&& currList.listSize==0)
            minFreq++;
        node.freq++;
        DoubleLinkedList newList=freqMap.getOrDefault(node.freq,new DoubleLinkedList());
        newList.addNode(node);
        freqMap.put(node.freq,newList);
    }

    private class DoubleLinkedList
    {
        int listSize;
        Node head;
        Node tail;
        DoubleLinkedList()
        {
            head=new Node(-1,-1);
            tail=new Node(-1,-1);
            this.head.next=tail;
            this.tail.prev=head;
            this.listSize=0;
        }
        void addNode(Node curr)
        {
            Node nextNode=head.next;
            head.next=curr;
            curr.prev=head;
            curr.next=nextNode;
            nextNode.prev=curr;
            listSize++;
        }
        void removeNode(Node curr)
        {
            Node prevNode=curr.prev;
            Node nextnode=curr.next;
            prevNode.next=nextnode;
            nextnode.prev=prevNode;
            listSize--;
        }
    }
    private class Node
    {
        Node next,prev;
        int key,value;
        int freq;
        Node(int key,int value)
        {
            this.next=null;
            this.prev=null;
            this.key=key;
            this.value=value;
            this.freq=1;
        }
    }
}
