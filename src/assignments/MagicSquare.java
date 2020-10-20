package assignments;

/**
 *
 * Magic Squares are square arrays of numbers that have the interesting property that
 * the numbers in each column, and in each row, all add up to the same total.
 *
 * Given an n x n square of numbers, determine if it is magic square.
 *
 * Reference: {@link java.lang.Integer}
 * Integer is a wrapper class for {@code int} primitive type.
 */
public class MagicSquare {
  /* n rows and n cols square */
  private int n;
  /* 2-Dimensional array to represent the square */
  private Integer[][] square;

  /**
   * Constructor that takes n as the number of rows and cols.
   * @param n number of rows and cols.
   */
  public MagicSquare(int n) {
    this.n = n;
    this.square = new Integer[n][n];
  }

  /**
   * Constructor that takes n as the number of rows and cols.
   * Initializes square 2-Dimensional array.
   * @param n number of rows and cols.
   * @param square
   */
  public MagicSquare(int n, Integer[][] square) {
    this.n = n;
    this.square = square;
  }

  /**
   * Getter for square
   * @return {@code this.square}
   */
  public Integer[][] getSquare() {
    return square;
  }

  /**
   * Setter for square.
   * @param square
   */
  public void setSquare(Integer[][] square) {
    this.square = square;
  }

  /**
   * Check if {@code square} is magic square or not. (static helper method)
   * @param square 2-Dimensional array
   * @return {@code true} if {@code square} is magic, otherwise {@code false}
   *
   * Sample Input
   * {
   *   {16, 3, 2, 13},
   *   {5, 10, 11, 8},
   *   {9, 6, 7, 12},
   *   {4, 15, 14, 1}
   * }
   *
   * Sample Output
   * true
   *
   * Explanation: The sums of each row and col are equal.
   */
  public static boolean isMagicSquare(Integer[][] square) {
    // store the rowSums in an array
    int firstRowSum = rowSum(0, square);
    int[] rowSums = new int[square.length];
    for (int r = 0; r < square.length; r++) {
      rowSums[r] = rowSum(r, square);
    }

    // check the rows
    for (int i = 0; i < square.length - 1; i++) {
      if (rowSums[i] != rowSums[i + 1]) {
        return false;
      }
    }

    // store the colSums in an array
    int[] colSums = new int[square.length];
    for (int c = 0; c < square.length; c++) {
      colSums[c] = colSum(c, square);
    }

    // make sure rowSum == colSum
    if (firstRowSum != colSums[0]) {
      return false;
    }

    // check the cols
    for (int i = 0; i < square.length - 1; i++) {
      if (colSums[i] != colSums[i + 1]) {
        return false;
      }
    }
    return true;
  }

  private static int colSum(int col, Integer[][] square) {
    int colSum = 0;
    for (int r = 0; r < square.length; r++) {
      colSum += square[r][col];
    }
    return colSum;
  }

  private static int rowSum(int row, Integer[][] square) {
    int rowSum = 0;
    for (int elem : square[row]) {
      rowSum += elem;
    }
    return rowSum;
  }

  /**
   * Check if {@code this.square} is magic square or not.
   * @return {@code true} if {@code square} is magic, otherwise {@code false}
   */
  public boolean isMagicSquare() {
    return isMagicSquare(this.square);
  }
}

