package chapter3;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Q3_4 {
  
  public static void main(String[] args) {
    List<Stack<Integer>> stacks=new ArrayList<Stack<Integer>>();
    stacks.add(new Stack<Integer>());
    stacks.add(new Stack<Integer>());
    stacks.add(new Stack<Integer>());
    
    for(int i=20;i>=0;i--){
      stacks.get(0).push(i);
    }
    
    System.out.println("stack0---"+stacks.get(0));
    System.out.println("stack1---"+stacks.get(1));
    System.out.println("stack2---"+stacks.get(2));
    
    move(stacks,0,2,stacks.get(0).size());
    
    System.out.println("stack0---"+stacks.get(0));
    System.out.println("stack1---"+stacks.get(1));
    System.out.println("stack2---"+stacks.get(2));
    
  }

  
  public static void move(List<Stack<Integer>> stacks, int from, int to, int n){
    for(Stack<Integer> stack:stacks){
      int last=-1;
      for(int i=stack.size()-1;i>=0;i--){
        if(stack.get(i)<last){
          throw new IllegalStateException();
        }
        last=stack.get(i);
      }
    }
    
    if(n==1){
      Integer item=stacks.get(from).pop();
      stacks.get(to).push(item);
      return;
    }
    
    int third=3-from-to;
    
    move(stacks,from,third,n-1);
    move(stacks,from,to,1);
    move(stacks,third,to,n-1);
  }
}
