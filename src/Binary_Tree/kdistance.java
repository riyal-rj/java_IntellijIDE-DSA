package Binary_Tree;

import java.util.*;

class kdistance {

    private static Map<TreeNode,TreeNode> parentmap;
    private static Set<Integer> visited;
    private static ArrayList<Integer> result;
    private void markParents(TreeNode root, TreeNode prev)
    {
        if(root==null)
            return;

        parentmap.put(root,prev);
        markParents(root.left,root);
        markParents(root.right,root);
    }
    private void dfs(TreeNode target,int k)
    {
        if(target==null || visited.contains(target.data))
            return;

        visited.add(target.data);
        if(k==0)
        {
            result.add(target.data);
            return;
        }
        dfs(target.left,k-1);
        dfs(target.right,k-1);
        dfs(parentmap.get(target),k-1);

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




        TreeNode target=root.left;
        kdistance obj=new kdistance();
        parentmap=new HashMap<>();
        visited=new HashSet<>();
        result=new ArrayList<>();
        obj.markParents(root,target);
        obj.dfs(target,2);
        for(int node:result)
            System.out.println(node);
    }
}
