package chapter2;

public class Node {
  int data;
  Node next;

  public Node(int d) {
    this.data = d;
    this.next=null;
  }
  
  public void addToTrail(Node n){
    Node current=this;
    while(current.next!=null){
      current=current.next;
    }
    
    current.next=n;
    n.next=null;
  }
  
  public String toString(){
    StringBuilder sb=new StringBuilder();
    
    sb.append(data);
    Node current=next;
    while(current!=null){
      sb.append("->");
      sb.append(current.data);
      current=current.next;
    }
    return sb.toString();
  }
}
