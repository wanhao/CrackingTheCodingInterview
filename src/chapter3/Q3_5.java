package chapter3;

import java.util.Stack;

public class Q3_5 {

  /**
   * @param args
   */
  public static void main(String[] args) {
    MyQueue<Integer> queue=new MyQueue<Integer>();
    
    queue.add(1);
    queue.add(2);
    queue.add(3);
    queue.add(4);
    queue.add(5);
    System.out.println(queue.remove());
    System.out.println(queue.remove());
    
    queue.add(6);
    queue.add(7);
    while(!queue.isEmpty()){      
      System.out.println(queue.remove());
    }
  }

  static class MyQueue<E> {
    private Stack<E> in = new Stack<E>();
    private Stack<E> out = new Stack<E>();

    public void add(E item) {
      in.push(item);
    }

    public E remove() {
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
