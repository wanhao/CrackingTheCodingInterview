package chapter4;

import java.util.ArrayList;
import java.util.LinkedList;

public class Q4_4 {
  
  public static void main(String[] args) {
    TreeNode root=new TreeNode(1);
    root.leftChild=new TreeNode(2);
    root.leftChild.leftChild=new TreeNode(3);
    root.leftChild.leftChild.leftChild=new TreeNode(4);
    
    root.rightChild=new TreeNode(5);
    root.rightChild.leftChild=new TreeNode(6);
    root.rightChild.rightChild=new TreeNode(7);
    
    ArrayList<LinkedList<TreeNode>> list=createLinkedListOfTree(root);
    for(LinkedList<TreeNode> linkedlist:list){
      for(TreeNode node:linkedlist){        
        System.out.print(node.data+"\t");
      }
      System.out.println();
    }
    
    System.out.println("------------------------");
    
    ArrayList<LinkedList<TreeNode>> list1=createLinkedListOfTree1(root);
    for(LinkedList<TreeNode> linkedlist:list1){
      for(TreeNode node:linkedlist){        
        System.out.print(node.data+"\t");
      }
      System.out.println();
    }
  }

  public static ArrayList<LinkedList<TreeNode>> createLinkedListOfTree(TreeNode root){
    ArrayList<LinkedList<TreeNode>> list=new ArrayList<LinkedList<TreeNode>>();
    createLinkedList(root,list,0);
    return list;
  }
  
  //depth first search
  public static void createLinkedList(TreeNode root, ArrayList<LinkedList<TreeNode>> list, int level){
    if(root==null) return;
    
    LinkedList<TreeNode> cur=null;
    
    if(level>list.size()-1){
      cur=new LinkedList<TreeNode>();
      list.add(cur);
    }else{
      cur=list.get(level);
    }
    cur.add(root);
    
    createLinkedList(root.leftChild, list, level+1);
    createLinkedList(root.rightChild, list, level+1);
  }
  
  //breadth first search
  public static ArrayList<LinkedList<TreeNode>> createLinkedListOfTree1(TreeNode root){
    if(root==null)return null;
    ArrayList<LinkedList<TreeNode>> list=new ArrayList<LinkedList<TreeNode>>();

    LinkedList<TreeNode> cur=new LinkedList<TreeNode>();
    cur.add(root);
    
    while(!cur.isEmpty()){
      list.add(cur);
      LinkedList<TreeNode> parent=cur;
      cur=new LinkedList<TreeNode>();
      for(TreeNode node:parent){
        if(node.leftChild!=null){
          cur.add(node.leftChild);
        }
        if(node.rightChild!=null){
          cur.add(node.rightChild);
        }
      }
    }
    return list;
  }
}
