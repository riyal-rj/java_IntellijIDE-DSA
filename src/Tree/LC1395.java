package Tree;
import java.lang.reflect.Array;
import java.util.Arrays;
public class LC1395 {
    public static void main(String[]args)
    {
        int [] ratings={2, 5, 3, 4, 1};
        numTeams(ratings);
    }
    public static int numTeams(int []ratings)
    {
        int n=ratings.length;
        if(n<3)
            return 0;

        int []sorted=ratings.clone();//clones an array with the elements of ratings[]
        Arrays.sort(sorted);//Sorts the cloned array
        //[1,2,3,4,5]

        //normalizing the rating based on the position after sorting
        for(int i=0;i<n;i++)
        {
            ratings[i]=Arrays.binarySearch(sorted,ratings[i]);
        }

        SegmentTree leftTree=new SegmentTree(new int[n]);
        SegmentTree rightTree=new SegmentTree(new int [n]);

        for(int r:ratings)
            rightTree.update(r,rightTree.query(r,r)+1);

        int totalTeams=0;

        for(int j=0;j<n;j++)
        {
            int r=ratings[j];
            rightTree.update(r,rightTree.query(r,r)-1);

        }
        


        return 0;
    }
    static class SegmentTree{
        private static class Node{
            int data;
            int startInterval;
            int endInterval;
            Node left,right;

            public Node(int startInterval,int endInterval) {
                this.startInterval = startInterval;
                this.endInterval = endInterval;
            }
        }
        Node root;
        public SegmentTree(int []arr)
        {
            this.root=constructTree(arr,0,arr.length-1);
        }
        private Node constructTree(int []arr,int start,int end)
        {
            if(start==end)
            {
                Node leaf=new Node(start,end);
                leaf.data=arr[start];
                return leaf;
            }

            Node internalNode=new Node(start,end);
            int mid=(start+end)/2;
            internalNode.left=constructTree(arr,start,mid);
            internalNode.right=constructTree(arr,mid+1,end);
            internalNode.data=internalNode.left.data+internalNode.right.data;
            return internalNode;
        }

        public int query(int qsi,int qei)
        {
            return query(this.root,qsi,qei);
        }
        private int query(Node node,int qsi,int qei)
        {
            if(node.startInterval>=qsi && node.endInterval<=qei)
                return node.data;
            if(node.startInterval>qei || node.endInterval<qsi)
                return 0;
            else
                return query(node.left,qsi,qei)+query(node.right,qsi,qei);
        }

        public void update(int index,int value)
        {
            update(this.root,index,value);
        }

        private int update(Node node,int index,int value)
        {
            if(index>=node.startInterval && index<node.endInterval)
            {
                if(node.startInterval==node.endInterval)
                {
                    return node.data=value;
                }
                else
                {
                    return node.data=update(node.left,index,value)+update(node.right,index,value);
                }
            }
            return node.data;
        }

    }
}


