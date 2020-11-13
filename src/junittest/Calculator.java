package junittest;

public class Calculator {
    public static int addition(int l, int r) throws ArithmeticException {
      long sum = (long) l + (long) r;
      if (sum > Integer.MAX_VALUE) {
        throw new ArithmeticException("Integer too big");
      } else if (sum < Integer.MIN_VALUE) {
        throw new ArithmeticException("Integer too small");
      } else {
        return l + r;
      }
    }
}
