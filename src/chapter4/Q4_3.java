package chapter4;

public class Q4_3 {

  public static void main(String[] args) {

  }
  
  public static TreeNode createBST(int[] a){
    return createBST(a,0,a.length-1);
  }
  
  public static TreeNode createBST(int[] a, int low, int high){
    if(low>high) return null;
    
    int middle=(low+high)/2;
    TreeNode root=new TreeNode(a[middle]);
    root.leftChild=createBST(a,low,middle-1);
    root.rightChild=createBST(a,middle+1,high);
    
    return root;
  }
}
