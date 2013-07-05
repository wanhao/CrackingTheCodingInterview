package chapter3;

import java.util.Stack;

public class Q3_6 {

  public static void main(String[] args) {
    Stack<Integer> stack = new Stack<Integer>();
    stack.push(10);
    stack.push(2);
    stack.push(3);
    stack.push(5);
    stack.push(5);
    stack.push(15);
    stack.push(20);
    stack.push(7);

    System.out.println(sort(stack));

    Stack<Integer> stack1 = new Stack<Integer>();
    stack1.push(10);
    System.out.println(sort(stack1));
  }

  public static Stack<Integer> sort(Stack<Integer> stack) {
    if (stack == null || stack.isEmpty()) return stack;

    Stack<Integer> buffer = new Stack<Integer>();

    Integer tmp1 = null, tmp2 = null;

    while (!stack.isEmpty()) {
      tmp1 = stack.peek();
      while (!buffer.isEmpty() && buffer.peek() > tmp1) {
        stack.push(buffer.pop());
      }
      buffer.push(tmp1);
      while ((tmp2 = stack.pop()) != tmp1) {
        buffer.push(tmp2);
      }
    }

    return buffer;
  }
}
