package Binary_Tree;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class inorder_and_preorder {
    private TreeNode construct_tree(ArrayList<Integer> inorder,ArrayList<Integer> preorder)
    {
        Map<Integer,Integer> inmap=new HashMap<>();
        for(int i=0;i<inorder.size();i++)
        {
            inmap.put(inorder.get(i),i);
        }

        TreeNode root=build(preorder,0,preorder.size()-1,inorder,0,inorder.size()-1,inmap);
        return root;
    }
    private TreeNode build(ArrayList<Integer> preorder,int preStart,int preEnd,ArrayList<Integer> inorder,int inStart,int inEnd,Map<Integer,Integer> inmap)
    {
        if(preStart>preEnd ||inStart>inEnd)
            return null;


        TreeNode root=new TreeNode(preorder.get(preStart));
        int inRoot=inmap.get(root.data);

        int numsleft=inRoot-inStart;

        root.left=build(preorder,preStart+1,preStart+numsleft,inorder,inStart,inRoot-1,inmap);
        root.right=build(preorder,preStart+numsleft+1,preEnd,inorder,inRoot+1,inEnd,inmap);

        return root;
    }
    private void inOrder(TreeNode root)
    {
        if(root==null)
            return;
        inOrder(root.left);
        System.out.println(root.data);
        inOrder(root.right);
    }
    public static void main(String[] args) {
        inorder_and_preorder obj=new inorder_and_preorder();
        ArrayList<Integer> inorder=new ArrayList<>(java.util.Arrays.asList(9,3,15,20,7));
        ArrayList<Integer> preorder=new ArrayList<>(java.util.Arrays.asList(3,9,20,15,7));

        System.out.println("Inorder Traversal: "+inorder);
        System.out.println("Preorder Traversal: "+preorder);
        TreeNode root=obj.construct_tree(inorder,preorder);
        System.out.println("Inorder after construction: ");
        obj.inOrder(root);

    }
}
