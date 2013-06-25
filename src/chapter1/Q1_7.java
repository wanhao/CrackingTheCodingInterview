package chapter1;

public class Q1_7 {

  public static void main(String[] args) {
    int[][] a =
        new int[][] { 
        { 1, 2, 3, 4, 5 }, 
        { 6, 7, 8, 9, 10 }, 
        { 11, 0, 0, 14, 15 },
        { 16, 17, 18, 19, 20 },
        { 21, 22, 23, 24, 0 } };

    for (int i = 0; i < 5; i++) {
      for (int j = 0; j < 5; j++) {
        System.out.print(a[i][j] + "\t");
      }
      System.out.println();
    }
    System.out.println("---------------------");
    setZero(a);
    for (int i = 0; i < 5; i++) {
      for (int j = 0; j < 5; j++) {
        System.out.print(a[i][j] + "\t");
      }
      System.out.println();
    }

    System.out.println("---------------------");
  }

  public static void setZero(int[][] matrix) {
    if (matrix == null) {
      return;
    }
    boolean rowFlag[] = new boolean[matrix.length];
    boolean columnFlag[]= new boolean[matrix[0].length];
    
    for(int i=0;i<matrix.length;i++){
      for(int j=0;j<matrix[i].length;j++){
        if(matrix[i][j]==0){
          rowFlag[i]=true;
          columnFlag[j]=true;
        }
      }
    }
    
    //set entire row to zero
    for(int row=0;row<rowFlag.length;row++){
      if(rowFlag[row]){
        for(int column=0;column<matrix[row].length;column++){
          matrix[row][column]=0;
        }
      }
    }
    
    //set entire column to zero
    for(int column=0;column<columnFlag.length;column++){
      if(columnFlag[column]){
        for(int row=0;row<matrix.length;row++){
          matrix[row][column]=0;
        }
      }
    }
  }
}
