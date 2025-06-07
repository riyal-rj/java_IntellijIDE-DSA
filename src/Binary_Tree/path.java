package Binary_Tree;

import java.util.ArrayList;

class path {

    private static ArrayList<Integer> result;
    private boolean getPath(TreeNode root, int dest)
    {
        if(root==null)
            return false;
        result.add(root.data);
        if(root.data==dest)
            return true;

        if(getPath(root.left,dest) || getPath(root.right,dest))
            return true;


        result.remove(result.size()-1);
        return false;
    }

    public static void main(String[] args) {
        path obj=new path();
        int dest=10;
        result=new ArrayList<>();
        TreeNode root = new TreeNode(20);
        root.left = new TreeNode(8);
        root.right = new TreeNode(22);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(25);
        root.left.right.left = new TreeNode(10);
        root.left.right.right = new TreeNode(14);
        System.out.println("Path from "+root.data+" to "+dest+" is: ");
        if(obj.getPath(root,dest))
            for(int val:result)
                System.out.println(val);

    }
}
