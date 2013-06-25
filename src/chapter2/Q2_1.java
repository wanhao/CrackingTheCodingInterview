package chapter2;

import java.util.HashSet;
import java.util.Set;

public class Q2_1 {

  public static void main(String[] args) {
    
    Node heada=new Node(2);
    heada.addToTrail(new Node(3));
    heada.addToTrail(new Node(2));
    heada.addToTrail(new Node(4));
    heada.addToTrail(new Node(2));
    heada.addToTrail(new Node(3));
    
    removeDuplicates1(heada);
    System.out.println(heada);
    
    Node headb=new Node(2);
    removeDuplicates1(headb);
    System.out.println(headb);
    
    
    Node headc=null;
    removeDuplicates1(headc);
    System.out.println(headc);
    
  }

  public static void removeDuplicates1(Node head) {
    Set<Integer> set=new HashSet<Integer>();
    
    Node previous=null;
    Node current=head;
    while(current!=null){
      if(set.contains(current.data)){
        previous.next=current.next;
      }else{
        set.add(current.data);
        previous=current;
      }
      current=current.next;
    }
    
  }

  public static void removeDuplicates2(Node head) {
    Node current=head;
    
    while(current!=null){
      Node runner=current;
      while(runner.next!=null){
        if(runner.next.data==current.data){
          runner.next=runner.next.next;
        }else{
          runner=runner.next;
        }
      }
      
      current=current.next;
    }
  }

}
