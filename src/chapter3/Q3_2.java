package chapter3;

import java.util.Stack;

public class Q3_2 {

  public static void main(String[] args) {
    StackWithMin stack=new StackWithMin();
    stack.push(15);
    stack.push(10);
    stack.push(8);
    stack.push(8);
    stack.push(4);
    stack.push(7);
    
    System.out.println(stack.min());
    
    stack.pop();
    System.out.println(stack.min());
    
    stack.pop();
    System.out.println(stack.min());
    
    stack.pop();
    System.out.println(stack.min());
    
    stack.pop();
    System.out.println(stack.min());
    
  }

  static class StackWithMin extends Stack<Integer> {
    Stack<Integer> stack = new Stack<Integer>();

    @Override
    public Integer push(Integer value) {
      if (value <= min()) {
        stack.push(value);
      }
      return super.push(value);
    }

    @Override
    public synchronized Integer pop() {
      Integer value = super.pop();
      if (value == min()) {
        stack.pop();
      }
      return value;
    }

    public Integer min() {
      if (stack.empty()) {
        return Integer.MAX_VALUE;
      } else {
        return stack.peek();
      }
    }
  }

}