package chapter1;

import java.util.Arrays;

public class Q1_3 {

  public static void main(String[] args) {
    String a="gbsdeg";
    String b="gdsegb";
    
    System.out.println(isAnagram1(a,b)+","+isAnagram2(a,b));

    a="gbsdeg";
    b="gdsegd";
    
    System.out.println(isAnagram1(a,b)+","+isAnagram2(a,b));
    
  }

  public static boolean isAnagram1(String a, String b) {
    if (a == null || b == null || a.length() != b.length()) {
      return false;
    }

    char[] letterA = a.toCharArray();
    char[] letterB = b.toCharArray();

    Arrays.sort(letterA);
    Arrays.sort(letterB);
    return Arrays.equals(letterA, letterB);
  }

  public static boolean isAnagram2(String a, String b) {
    if (a == null || b == null || a.length() != b.length()) {
      return false;
    }

    int[] letterA = new int[256];
    for (int i = 0; i < a.length(); i++) {
      letterA[a.charAt(i)]++;
    }

    for (int i = 0; i < b.length(); i++) {
      if (--letterA[b.charAt(i)] < 0) {
        return false;
      }
    }
    return true;
  }

}
