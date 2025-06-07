package Binary_Tree;

class lowest_common_ancestor {
    private TreeNode lowestcommonancestor(TreeNode root,int node1, int node2)
    {
        if(root==null || node1==root.data ||node2==root.data)
            return root;

        TreeNode left=lowestcommonancestor(root.left,node1,node2);
        TreeNode right=lowestcommonancestor(root.right,node1,node2);


        if(left==null)
            return  right;
        else if(right==null)
            return  left;
        else
            return root;
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

        lowest_common_ancestor obj=new lowest_common_ancestor();
        System.out.println("Lowest Common ancestor of "+8+" and "+14+" is: "+obj.lowestcommonancestor(root,8,14).data);
    }
}
