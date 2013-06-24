package chapter1;

public class Q1_5 {

  public static void main(String[] args) {
   String a="aabbb";
   System.out.println(compress(a));

  }
  
  public static String compress(String str){
    if(str==null || countSize(str)>= str.length()){
      return str;
    } 
    
    StringBuilder sb=new StringBuilder();
    char cur=str.charAt(0);
    int count=1;
    
    for(int i=1;i<str.length();i++){
      if(cur==str.charAt(i)){
        count++;
      }else{
        sb.append(cur);
        sb.append(count);
        cur=str.charAt(i);
        count=1;
      }
    }
    
    sb.append(cur);
    sb.append(count);
    
    return sb.toString();
  }
  
  private static int countSize(String str){
    if(str==null || str.isEmpty()){
      return 0;
    }
    
    char cur=str.charAt(0);
    int count=1;
    int size=0;
    
    for(int i=1;i<str.length();i++){
      if(cur==str.charAt(i)){
        count++;
      }else{
        size+=1+ Integer.toString(count).length();
        cur=str.charAt(i);
        count=1;
      }
    }
    size+=1+ Integer.toString(count).length();
    
    return size;
  }
  

}
