package Binary_Tree;

public class children_Sum {
    private  static void  make_children_sum(TreeNode root)
    {
        if(root==null)
            return;
        int sum=0;
        if(root.left!=null)
            sum+=root.left.data;
        if(root.right!=null)
            sum+=root.right.data;
        if(sum>=root.data)
            root.data=sum;
        else
        {
            if(root.left!=null)
                root.left.data=root.data;
            if(root.right!=null)
                root.right.data= root.data;
        }
        make_children_sum(root.left);
        make_children_sum(root.right);

        int tot=0;
        if(root.left!=null)
            tot+=root.left.data;
        if(root.right!=null)
            tot+=root.right.data;
        if(root.left!=null || root.right!=null)
            root.data=tot;
    }
    private static void inorder(TreeNode root)
    {
        if(root==null)
            return;
        inorder(root.left);
        System.out.println(root.data);
        inorder(root.right);
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
        System.out.println("Before: ");
        inorder(root);
        make_children_sum(root);
        System.out.println("After: ");
        inorder(root);
    }
}
