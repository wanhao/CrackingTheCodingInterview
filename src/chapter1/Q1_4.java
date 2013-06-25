package chapter1;

import java.util.Arrays;

public class Q1_4 {

  public static void main(String[] args) {
    char a[] = new char[20];
    a[0]=' ';
    a[1]='s';
    a[2]=' ';
    a[3]='g';
    
    replaceSpaces(a,0);
    System.out.println(Arrays.toString(a));
    
    replaceSpaces(a,4);
    System.out.println(Arrays.toString(a));
    
    replaceSpaces(a,21);
    System.out.println(Arrays.toString(a));
  }

  public static void replaceSpaces(char[] str, int len){
    if(str==null || str.length<len){return;}
    
    int spaceCount=0;
    for(int i=0;i<len;i++){
      if(str[i]==' ') spaceCount++;
    }
    
    int newLen=len+(spaceCount<<1);
    str[newLen--]='\0';
    
    for(int i=len-1;i>=0;i--){
      if(str[i]==' '){
        str[newLen-2]='%';
        str[newLen-1]='2';
        str[newLen]='0';
        newLen-=3;
      }else{
        str[newLen]=str[i];
        newLen--;
      }
    }
  }
}
