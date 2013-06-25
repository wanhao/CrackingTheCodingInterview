package chapter1;

public class Q1_8 {

  public static void main(String[] args) {
    String s1 = "abcdef";
    String s2 = "cdefab";
    String s3 = "abcdef";

    System.out.println(isRotation(s1, s2));
    System.out.println(isRotation(s1, s3));
  }

  public static boolean isRotation(String s1, String s2) {
    if (s1 == null || s2 == null || s1.length() != s2.length()) {
      return false;
    }

    String s1s1 = s1 + s1;
    return isSubstring(s1s1, s2);
  }

  public static boolean isSubstring(String s1, String s2) {
    return s1.contains(s2);
  }
}
