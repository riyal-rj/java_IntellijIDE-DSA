package Binary_Tree;

import java.util.ArrayList;
import java.util.List;

class right_left_view {
     private static ArrayList<Integer> left_view_rs;
     private static ArrayList<Integer> right_view_rs;
    private void  right_view(TreeNode root,int level)
    {
        if(root==null)
            return;
        if(level==right_view_rs.size())
            right_view_rs.add(root.data);

        right_view(root.right,level+1);
        right_view(root.left,level+1);
    }
    private void left_view(TreeNode root,int level)
    {
        if(root==null)
            return;
        if(level==left_view_rs.size())
            left_view_rs.add(root.data);

        left_view(root.left, level+1);
        left_view(root.right,level+1);
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

        right_left_view obj=new right_left_view();
        right_view_rs=new ArrayList<>();
        left_view_rs=new ArrayList<>();
        obj.right_view(root,0);
        obj.left_view(root,0);
        System.out.println("Right view of the Tree: ");
        for(int val: right_view_rs)
            System.out.println(val);

        System.out.println("Left view of the Tree: ");
        for (int val:left_view_rs)
            System.out.println(val);

    }

}
