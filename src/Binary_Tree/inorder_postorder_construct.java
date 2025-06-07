package Binary_Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class inorder_postorder_construct {
    private TreeNode construct_tree(ArrayList<Integer> inorder,ArrayList<Integer>postorder)
    {
        if(inorder.size()!=postorder.size())
            return null;

        Map<Integer,Integer> inMap=new HashMap<>();
        for(int i=0;i<inorder.size();i++)
        {
            inMap.put(inorder.get(i),i);
        }
        return build(inorder,0,inorder.size()-1,postorder,0,postorder.size()-1,inMap);
    }
    private TreeNode build(ArrayList<Integer> inorder,int inStart,int inEnd,ArrayList<Integer> postorder,int postStart,int postEnd,Map<Integer,Integer> inMap)
    {
        if(postStart>postEnd || inStart>inEnd)
            return null;

        TreeNode root=new TreeNode(postorder.get(postEnd));

        int inRoot=inMap.get(postorder.get(postEnd));

        int numsLeft=inRoot-inStart;

        root.left=build(inorder,inStart,inRoot-1,postorder,postStart,postStart+numsLeft-1,inMap);
        root.right=build(inorder,inRoot+1,inEnd,postorder,postStart+numsLeft,postEnd-1,inMap);

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
        ArrayList<Integer> inorder=new ArrayList<>(java.util.Arrays.asList(40,20,50,10,60,30));
        ArrayList<Integer> postorder=new ArrayList<>(java.util.Arrays.asList(40,50,20,60,30,10));
        System.out.println("Inorder Traversal: "+inorder);
        System.out.println("Postorder Traversal: "+postorder);

        inorder_postorder_construct obj=new inorder_postorder_construct();
        TreeNode root=obj.construct_tree(inorder,postorder);
        System.out.println("Inorder after construction: ");
        obj.inOrder(root);
    }
}
