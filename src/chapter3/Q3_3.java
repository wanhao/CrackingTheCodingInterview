package chapter3;

import java.util.ArrayList;
import java.util.Stack;

public class Q3_3 {

  public static void main(String[] args) {
    String a="abc";
    String b="abc";
    System.out.println(a==b);
    
  }
  
  static class SetOfStack<E>{
    private ArrayList<Stack<E>> stacks=new ArrayList<Stack<E>>();
    
    private int maxSize=0;
    public SetOfStack(int maxElementPerStack){
      this.maxSize=maxElementPerStack;
    }
    
    public void push(E item){
      Stack<E> stack=null;
      if(stacks.isEmpty() || (stack=stacks.get(stacks.size()-1)).size()>=maxSize){
        stack=new Stack<E>();
        stacks.add(stack);
      }
      stack.push(item);
    }
    
    public E pop(){
      if(stacks.isEmpty())return null;
      Stack<E> stack=stacks.get(stacks.size()-1);
      
      E item=stack.pop();
      if(stack.empty()){
        stacks.remove(stacks.size()-1);
      }
      
      return item;
    }
    
    
  }

}
