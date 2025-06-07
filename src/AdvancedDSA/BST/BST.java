package AdvancedDSA.BST;

import AdvancedDSA.TreeNode.TreeNode;

public class BST
{

    public TreeNode root;
    public BST(int rootVal)
    {
        this.root=new TreeNode(rootVal);
    }
    public BST()
    {
        this.root=null;
    }
    TreeNode insertOperation(TreeNode node,int value)
    {
        if(node==null)
        {
            return new TreeNode(value);
        }
        if(value>node.data)
            node.rightChild=insertOperation(node.rightChild,value);
        else if(value< node.data)
            node.leftChild=insertOperation(node.leftChild,value);
        return node;
    }
    void insert(int value)
    {
        root=insertOperation(root,value);
    }
    void inOrder(TreeNode node)
    {
        if(node==null)
            return;
        inOrder(node.leftChild);
        System.out.println(node.data);
        inOrder(node.rightChild);
    }


}

class Test
{
    public static void main(String[] args) {
        BST bstObj=new BST(100);
        bstObj.insert(5);
        bstObj.insert(200);
        bstObj.insert(150);

        bstObj.inOrder(bstObj.root);

    }
}
