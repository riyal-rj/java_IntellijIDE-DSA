package Binary_Tree;



import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

class burn_tree {
    private HashMap<TreeNode,TreeNode> parentMap;
    private static TreeNode startNode;
    private void trackParents(TreeNode root,int start)
    {
        if(root==null)
            return;
        Queue<TreeNode> qobj=new LinkedList<>();
        qobj.add(root);
        while(!qobj.isEmpty())
        {
            TreeNode node=qobj.poll();
            if(node.data==start)
                startNode=node;

            if(node.left!=null) {
                parentMap.put(node.left, node);
                qobj.add(node.left);
            }

            if(node.right!=null)
            {
                parentMap.put(node.right,node);
                qobj.add(node.right);
            }
        }
    }
    private int findMaxDistance(TreeNode target)
    {
        Queue<TreeNode> qob=new LinkedList<>();
        qob.add(target);
        Map<TreeNode,Boolean> visited=new HashMap<>();
        visited.put(target,true);
        int max_dist=0;
        while(!qob.isEmpty())
        {
            int size=qob.size();
            boolean flag=false;

            for(int i=0;i<size;i++)
            {
                TreeNode temp=qob.poll();
                if(temp.left!=null && !visited.containsKey(temp.left))
                {
                    flag=true;
                    visited.put(temp.left,true);
                    qob.add(temp.left);
                }
                if(temp.right!=null && !visited.containsKey(temp.right))
                {
                    flag=true;
                    visited.put(temp.right,true);
                    qob.add(temp.right);
                }
                TreeNode parentNode=parentMap.get(temp);
                if(parentNode!=null && !visited.containsKey(parentNode))
                {
                    flag=true;
                    visited.put(parentNode,true);
                    qob.add(parentNode);
                }
            }
            if(flag)
                max_dist++;
        }

        return max_dist;

    }
    private int time_to_burn(TreeNode root,int start)
    {
        parentMap=new HashMap<>();
        trackParents(root,start);
        return findMaxDistance(startNode);
    }

    public static void main(String[] args) {
        burn_tree obj=new burn_tree();
        TreeNode root = new TreeNode(20);
        root.left = new TreeNode(8);
        root.right = new TreeNode(22);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(25);
        root.left.right.left = new TreeNode(10);
        root.left.right.right = new TreeNode(14);
        int time=obj.time_to_burn(root,22);
        System.out.println(time);

    }

}
