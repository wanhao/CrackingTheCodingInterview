package chapter2;

public class Q2_2 {
  
  
  public static void main(String[] args) {
    Node heada=new Node(6);
    heada.addToTrail(new Node(5));
    heada.addToTrail(new Node(4));
    heada.addToTrail(new Node(3));
    heada.addToTrail(new Node(2));
    heada.addToTrail(new Node(1));
    
    Node result=getKth(heada,0);
    System.out.println(result==null?"null":""+result.data);

    result=getKth(heada,3);
    System.out.println(result==null?"null":""+result.data);

    result=getKth(heada,6);
    System.out.println(result==null?"null":""+result.data);

    result=getKth(heada,7);
    System.out.println(result==null?"null":""+result.data);

  }

  
  public static Node getKth(Node head, int k){
    if(head==null || k<=0){
      return null;
    }
    
    int i=0;
    Node p1=head,p2=head;
    while(p2!=null && i<k){
      p2=p2.next;
      i++;
    }
    if(i!=k){
      return null;
    }
    
    while(p2!=null){
      p2=p2.next;
      p1=p1.next;
    }
    
    return p1;
  }
}
