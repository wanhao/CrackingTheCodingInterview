package chapter4;

public class Q4_5 {

  public static void main(String[] args) {
    TreeNode root=new TreeNode(20);
    root.leftChild=new TreeNode(10);
    root.leftChild.leftChild=null;
    root.leftChild.rightChild=new TreeNode(25);
    root.rightChild=new TreeNode(30);
    
    System.out.println(isBST(root));
    System.out.println(isBST(root,Integer.MIN_VALUE,Integer.MAX_VALUE));
    
    root.leftChild.leftChild=new TreeNode(5);
    root.leftChild.rightChild=new TreeNode(15);
    System.out.println(isBST(root));
    System.out.println(isBST(root,Integer.MIN_VALUE,Integer.MAX_VALUE));
  }

  public static boolean isBST(TreeNode root, int min, int max) {
    if (root == null) return true;

    if (root.data > max || root.data <= min) return false;

    if (!isBST(root.leftChild, min, root.data) || !isBST(root.rightChild, root.data, max)) return false;
    return true;
  }

  static class Value {
    public int min;
    public int max;

    public Value(int min, int max) {
      this.min = min;
      this.max = max;
    }
  }

  public static boolean isBST(TreeNode root) {
    return checkBST(root) == null ? false : true;
  }

  public static Value checkBST(TreeNode root) {
    if (root == null) return new Value(Integer.MAX_VALUE, Integer.MIN_VALUE);

    Value left = checkBST(root.leftChild);
    if (left == null) return null;

    Value right = checkBST(root.rightChild);
    if (right == null) return null;

    if (root.data < left.max || root.data >= right.min) return null;

    int min = Math.min(root.data, left.min);
    int max = Math.max(root.data, right.max);
    return new Value(min, max);
  }

}
