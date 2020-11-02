public class MidtermPreview {
  public static void main(String[] args) {
    // Using Math.random(), how can I generate a random int from 1 <=   <= 10
    // 0 <= Math.random() < 1
    // 1 <= (int) Math.random() * 10 + 1 < 11
    // 0.123, 0.5555, 0.9991, ...
    System.out.println((int) (Math.random() * 10) + 1);

    // min <=  < max
    // (int) (Math.random() * (max - min)) + min

    // ex)  5 <=   < 10
    System.out.println((int) (Math.random() * (5)) + 5);

    // ex)  10 <=    <= 20
    //  <=> 10 <=    < 21
    System.out.println((int) (Math.random() * (11)) + 10);

    // Method Overloading: "Parameters"
    getSum(10, 10);  // 1
    getSum(10.0, 10); // 2
  }

  // 1
  public static int getSum(int a, int b) {
    return a + b;
  }

  // 2
  public static int getSum(double a, int b) {
    return 0;
  }
}
