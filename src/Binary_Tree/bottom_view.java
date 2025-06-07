package Binary_Tree;




import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

class bottom_view {
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

    private void bottom_view(TreeNode root)
    {
        Queue<Pair> qobj=new LinkedList<>();
        Map<Integer,TreeNode> map=new TreeMap<>();

        if(root==null)
            return;
        else
            qobj.add(new Pair(root,0));

        System.out.println("Bottom view of the Tree: ");
        while(!qobj.isEmpty())
        {
            Pair temp=qobj.poll();
            map.put(temp.ver, temp.node);
            if(temp.node.left!=null)
                qobj.add(new Pair(temp.node.left, temp.ver-1));
            if(temp.node.right!=null)
                qobj.add(new Pair(temp.node.right, temp.ver+1));
        }

        for(TreeNode node:map.values())
            System.out.println(node.data);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(20);
        root.left = new TreeNode(8);
        root.right = new TreeNode(22);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(25);
        root.left.right.left = new TreeNode(10);
        root.left.right.right = new TreeNode(14);

        bottom_view obj=new bottom_view();
        obj.bottom_view(root);
    }
}
