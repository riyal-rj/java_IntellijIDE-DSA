package Binary_Tree;

import java.util.LinkedList;
import java.util.Queue;

public class serialize_and_deserialize {
    private String serialize(TreeNode root)
    {
        if(root==null)
            return "";
        StringBuilder sb=new StringBuilder();
        Queue<TreeNode> qobj=new LinkedList<>();
        qobj.add(root);

        while(!qobj.isEmpty())
        {
            TreeNode curr=qobj.poll();
            if(curr==null)
                sb.append("n,");
            else
            {
                sb.append(curr.data).append(",");

                qobj.add(curr.left);
                qobj.add(curr.right);
            }
        }
        return sb.toString();
    }

    private TreeNode deserialize(String str)
    {
        if(str.isEmpty())
            return null;


        StringBuilder sb=new StringBuilder(str);
        int comma_index=sb.indexOf(",");
        String str1=sb.substring(0,comma_index);
        sb.delete(0,comma_index+1);
        TreeNode root=new TreeNode(Integer.parseInt(str1));
        Queue<TreeNode> qobj=new LinkedList<>();
        qobj.add(root);
        while (!qobj.isEmpty())
        {
            TreeNode temp=qobj.poll();

            comma_index=sb.indexOf(",");
            str1=sb.substring(0,comma_index);
            sb.delete(0,comma_index+1);

            if(!str1.equals("n"))
            {
                TreeNode left=new TreeNode(Integer.parseInt(str1));
                temp.left=left;
                qobj.add(left);
            }

            comma_index=sb.indexOf(",");
            str1=sb.substring(0,comma_index);
            sb.delete(0,comma_index+1);


            if(!str1.equals("n"))
            {
                TreeNode right=new TreeNode(Integer.parseInt(str1));
                temp.right=right;
                qobj.add(right);
            }


        }
        return  root;

    }
    private void inorder(TreeNode root)
    {
        if(root==null)
            return;
        inorder(root.left);
        System.out.println(root.data);
        inorder(root.right);
    }

    public static void main(String[] args) {
        serialize_and_deserialize obj=new serialize_and_deserialize();
        TreeNode root = new TreeNode(20);
        root.left = new TreeNode(8);
        root.right = new TreeNode(22);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(25);
        root.left.right.left = new TreeNode(10);
        root.left.right.right = new TreeNode(14);
        obj.inorder(root);
        String ser_res=obj.serialize(root);
        System.out.println("Serialization of the Binary Tree: "+ser_res);

        TreeNode des_root=obj.deserialize(ser_res);
        obj.inorder(des_root);
    }
}
