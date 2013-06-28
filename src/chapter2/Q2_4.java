package chapter2;

public class Q2_4 {

  public static void main(String[] args) {
    Node head=new Node(6);
    head.addToTrail(new Node(5));
    head.addToTrail(new Node(4));
    head.addToTrail(new Node(3));
    head.addToTrail(new Node(2));
    head.addToTrail(new Node(1));
    
    head=partition(head,10);
    System.out.println(head);
    
    head=partition(head,4);
    System.out.println(head);
    
    head=partition(head,0);
    System.out.println(head);
    
  }
  
  public static Node partition(Node list, int x){
    Node start1=null;
    Node last1=null;
    Node start2=null;
    Node last2=null;
    
    while(list!=null){
      if(list.data<x){
        if(last1== null){
          start1=list;
          last1=list;
        }else{
          last1.next=list;
          last1=list;
        }
      }else{
        if(last2==null){
          start2=list;
          last2=list;
        }else{
          last2.next=list;
          last2=list;
        }
      }
      list=list.next;
    }
    
    if(start1==null){
      return start2;
    }else if(start2==null){
      return start1;
    }else{
      last1.next=start2;
      last2.next=null;
      return start1;
    }
  }

}
