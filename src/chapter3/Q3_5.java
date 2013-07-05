package chapter3;

import java.util.Stack;

public class Q3_5 {

  /**
   * @param args
   */
  public static void main(String[] args) {
    MyQueue<Integer> queue=new MyQueue<Integer>();
    
    queue.enqueue(1);
    queue.enqueue(2);
    queue.enqueue(3);
    queue.enqueue(4);
    queue.enqueue(5);
    System.out.println(queue.dequeue());
    System.out.println(queue.dequeue());
    
    queue.enqueue(6);
    queue.enqueue(7);
    while(!queue.isEmpty()){      
      System.out.println(queue.dequeue());
    }
  }

  static class MyQueue<E> {
    private Stack<E> in = new Stack<E>();
    private Stack<E> out = new Stack<E>();

    public void enqueue(E item) {
      in.push(item);
    }

    public E dequeue() {
      if(out.isEmpty()){
        while(!in.isEmpty()){
          out.push(in.pop());
        }
      }
      
      if(out.isEmpty()){
        return null;
      }
      return out.pop();
    }
    
    public boolean isEmpty(){
      return in.isEmpty()&&out.isEmpty();
    }

  }

}
