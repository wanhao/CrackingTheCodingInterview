package chapter4;

public class TreeNode {
  public int data;
  public TreeNode leftChild;
  public TreeNode rightChild;
  
  public TreeNode(int data) {
    this(data,null,null);
  }
  
  public TreeNode(int data, TreeNode leftChild, TreeNode rightChild) {
    this.data = data;
    this.leftChild = leftChild;
    this.rightChild = rightChild;
  }
  
}
