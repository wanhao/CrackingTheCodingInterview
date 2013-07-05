package chapter4;

public class Q4_1 {
  
  public static void main(String[] args) {
    TreeNode root=new TreeNode(1);
    root.leftChild=new TreeNode(2);
    root.leftChild.leftChild=new TreeNode(3);
    root.leftChild.leftChild.leftChild=new TreeNode(4);
    
    root.rightChild=new TreeNode(5);
    root.rightChild.leftChild=new TreeNode(6);
    root.rightChild.rightChild=new TreeNode(7);
    
    System.out.println(isBalanced(root));
  }

  public static boolean isBalanced(TreeNode root){
    return checkHeight(root)<0?false:true;
  }
  
  public static int checkHeight(TreeNode root){
    if(root==null)return 0;
    
    int leftHeight=checkHeight(root.leftChild);
    if(leftHeight<0){
      return -1;
    }
    
    int rightHeight=checkHeight(root.rightChild);
    if(rightHeight<0){
      return -1;
    }
    
    if(Math.abs(leftHeight-rightHeight)>1){
      return -1;
    }else{
      return Math.max(leftHeight,rightHeight)+1;
    }
  }
}
