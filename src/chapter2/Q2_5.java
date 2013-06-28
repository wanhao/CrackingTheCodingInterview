package chapter2;

public class Q2_5 {


  public static void main(String[] args) {
    Node list1=new Node(6);
    list1.addToTrail(new Node(5));
    list1.addToTrail(new Node(4));
    list1.addToTrail(new Node(3));
    list1.addToTrail(new Node(2));
    list1.addToTrail(new Node(1));
    
    Node list2=new Node(5);
    list2.addToTrail(new Node(7));
    list2.addToTrail(new Node(3));
    list2.addToTrail(new Node(2));
    
    System.out.println(list1);
    System.out.println(list2);
    
    System.out.println();
    System.out.println(reverseAdd(list1,list2));
    System.out.println(reverseAdd(list2,list1));
    System.out.println(reverseAdd(list1,null));
    System.out.println(reverseAdd(null,null));
    
    System.out.println();
    System.out.println(forwardAdd(list1,list2));
    System.out.println(forwardAdd(list2,list1));
    System.out.println(forwardAdd(list1,null));
    System.out.println(forwardAdd(null,null));
  }

  public static Node reverseAdd(Node list1, Node list2){
    Node head=null,last=null;
    int sum=0,carry=0;
    
    while(list1!=null || list2!=null || carry!=0){
      sum=carry;
      if(list1!=null){
        sum+=list1.data;
        list1=list1.next;
      }
      
      if(list2!=null){
        sum+=list2.data;
        list2=list2.next;
      }
      
      Node tmp=new Node(sum%10);
      if(last==null){
        head=tmp;
        last=tmp;
      }else{
        last.next=tmp;
        last=last.next;
      }
      
      carry=sum/10;
    }
    
    return head;
  }
  
  public static Node forwardAdd(Node list1,Node list2){
    int len1=length(list1);
    int len2=length(list2);
    
    Result r=recursiveAdd(list1, len1, list2, len2);
    if(r.carry!=0){
      appendBefore(r,r.carry);
    }
    return r.node;
  }
  
  static class Result{
    Node node=null;
    int carry=0;
    
    public Result(){
      this.node=null;
      this.carry=0;
    }
    
    public Result(Node n, int c){
      this.node=n;
      this.carry=c;
    }
  }
  
  public static Result recursiveAdd(Node list1, int x, Node list2, int y){
    if(x==0 && y==0) {
      return new Result();
    }
    if(x<y){
      return recursiveAdd(list2,y,list1,x);
    }else if(x==y){
      Result r=recursiveAdd(list1.next, x-1, list2.next, y-1);
      int sum=r.carry+list1.data+list2.data;
      appendBefore(r,sum);
      return r;
    }else{
      Result r=recursiveAdd(list1.next, x-1,list2,y);
      int sum=r.carry+list1.data;
      appendBefore(r,sum);
      return r;
    }
    
  }
  
  static void appendBefore(Result r, int sum){
    Node tmp=new Node(sum%10);
    tmp.next=r.node;
    r.node=tmp;
    r.carry=sum/10;
  }
  
  static int length(Node head){
    int len=0;
    while(head!=null){
      len++;
      head=head.next;
    }
    return len;
  }
  
}
