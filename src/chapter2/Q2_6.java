package chapter2;

public class Q2_6 {

  public static void main(String[] args) {
    Node list=new Node(6);
    list.addToTrail(new Node(5));
    list.addToTrail(new Node(4));
    list.addToTrail(new Node(3));
    list.addToTrail(new Node(2));
    list.addToTrail(new Node(1));
    
    System.out.println(findLoopStart(list));
    
    list=new Node(6);
    list.addToTrail(new Node(5));
    list.addToTrail(new Node(4));
    Node a,b;
    list.addToTrail(a=new Node(3));
    list.addToTrail(new Node(2));
    list.addToTrail(b=new Node(1));
    b.next=a;
    System.out.println(findLoopStart(list).data);
  }

  public static Node findLoopStart(Node head) {
    Node slow = head;
    Node fast = head;

    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
      if (slow == fast) break;
    }

    if (fast == null || fast.next == null) return null;
    
    slow = head;
    while (slow != fast) {
      slow = slow.next;
      fast = fast.next;
    }
    return slow;
  }
}
