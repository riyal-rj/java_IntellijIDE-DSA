package Binary_Tree;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;


public class top_view {
    private class Pair
    {
        TreeNode node;
        int ver;
        Pair(TreeNode node,int ver)
        {
            this.node=node;
            this.ver=ver;
        }

    }
private void TopView(TreeNode root)
{
    Queue<Pair> qobj=new LinkedList<>();
    Map<Integer,TreeNode> map=new TreeMap<>();

    if(root==null)
        return;
    else
        qobj.add(new Pair(root,0));
    System.out.println("Top view of the tree: ");
    while(!qobj.isEmpty())
    {
        Pair temp=qobj.poll();
        if(!map.containsKey(temp.ver))
            map.put(temp.ver, temp.node);

        if(temp.node.left!=null)
            qobj.add(new Pair(temp.node.left,temp.ver-1));
        if(temp.node.right!=null)
            qobj.add(new Pair(temp.node.right,temp.ver+1));
    }
    for(TreeNode val:map.values())
    {
        System.out.println(val.data);
    }
}

    public static void main(String[] args) {
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.left.left=new TreeNode(4);
        root.left.right=new TreeNode(10);
        root.left.left.right=new TreeNode(5);
        root.left.left.right.right=new TreeNode(6);
        root.right=new TreeNode(3);
        root.right.right=new TreeNode(10);
        root.right.left=new TreeNode(9);

        top_view t=new top_view();
        t.TopView(root);
    }
}
