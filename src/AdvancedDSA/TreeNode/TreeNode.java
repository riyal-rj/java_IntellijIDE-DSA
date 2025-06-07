package AdvancedDSA.TreeNode;

public class TreeNode {
    public int data;
    public TreeNode leftChild;
    public TreeNode rightChild;
    public TreeNode(int data)
    {
        this.data=data;
        this.leftChild=null;
        this.rightChild=null;
    }
    TreeNode(int data, TreeNode leftChild, TreeNode rightChild)
    {
        this.data=data;
        this.leftChild=leftChild;
        this.rightChild=rightChild;
    }
}
