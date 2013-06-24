package chapter1;

public class Q1_6 {

  public static void main(String[] args) {
    int[][] a =
        new int[][] { { 1, 2, 3, 4, 5 }, { 6, 7, 8, 9, 10 }, { 11, 12, 13, 14, 15 },
            { 16, 17, 18, 19, 20 }, { 21, 22, 23, 24, 25 } };

    for (int i = 0; i < 5; i++) {
      for (int j = 0; j < 5; j++) {
        System.out.print(a[i][j] + "\t");
      }
      System.out.println();
    }
    System.out.println("---------------------");
    rotate1(a, 5);
    for (int i = 0; i < 5; i++) {
      for (int j = 0; j < 5; j++) {
        System.out.print(a[i][j] + "\t");
      }
      System.out.println();
    }

    System.out.println("---------------------");

    a = new int[][] { { 1, 2, 3, 4 }, { 5, 6, 7, 8, }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };

    for (int i = 0; i < 4; i++) {
      for (int j = 0; j < 4; j++) {
        System.out.print(a[i][j] + "\t");
      }
      System.out.println();
    }
    System.out.println("---------------------");
    rotate1(a, 4);
    for (int i = 0; i < 4; i++) {
      for (int j = 0; j < 4; j++) {
        System.out.print(a[i][j] + "\t");
      }
      System.out.println();
    }

    System.out.println("---------------------");
  }

  public static void rotate(int[][] matrix, int n) {
    if (matrix == null) return;

    for (int x = 0; x <= (n - 1) / 2; x++) {
      for (int y = 0; y < n / 2; y++) {
        int tmp = matrix[x][y];
        matrix[x][y] = matrix[n - 1 - y][x];
        matrix[n - 1 - y][x] = matrix[n - 1 - x][n - 1 - y];
        matrix[n - 1 - x][n - 1 - y] = matrix[y][n - 1 - x];
        matrix[y][n - 1 - x] = tmp;
      }
    }
  }

  public static void rotate1(int[][] matrix, int n) {
    for (int layer = 0; layer < n / 2; ++layer) {
      int first = layer;
      int last = n - 1 - layer;
      for (int i = first; i < last; ++i) {
        int offset = i - first;
        // save top
        int top = matrix[first][i];

        // left -> top
        matrix[first][i] = matrix[last - offset][first];

        // bottom -> left
        matrix[last - offset][first] = matrix[last][last - offset];

        // right -> bottom
        matrix[last][last - offset] = matrix[i][last];

        // top -> right
        matrix[i][last] = top;
      }
    }
  }

}
