package chapter2;

public class Q2_3 {

  public static void main(String[] args) {
    Node middle=null;
    Node last=null;
    Node head=new Node(6);
    head.addToTrail(new Node(5));
    head.addToTrail(new Node(4));
    head.addToTrail(middle=new Node(3));
    head.addToTrail(new Node(2));
    head.addToTrail(last=new Node(1));
    
    System.out.println(deleteNode(head));
    System.out.println(head);
    
    System.out.println(deleteNode(middle));
    System.out.println(head);
    
    System.out.println(deleteNode(last));
    System.out.println(head);
  }

  public static boolean deleteNode(Node middle){
    if(middle==null || middle.next==null){
      return false;
    }
    
    middle.data=middle.next.data;
    middle.next=middle.next.next;
    return true;
  }
}
