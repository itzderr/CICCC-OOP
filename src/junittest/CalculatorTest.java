package junittest;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

  @org.junit.jupiter.api.BeforeAll
  static void setupAll() {

  }

  @org.junit.jupiter.api.BeforeEach
  void setUp() {
  }

  @org.junit.jupiter.api.AfterEach
  void tearDown() {
  }

  @org.junit.jupiter.api.Test
  void additionBothPositive() {
    // l: pos, r: pos
    int l = 20;
    int r = 30;
    assertEquals(50, Calculator.addition(l, r));
  }

  @org.junit.jupiter.api.Test
  void additionBothNegative() {
    // l: neg, l: neg
    int l = -20;
    int r = -30;
    assertEquals(-50, Calculator.addition(l, r));
  }

  @org.junit.jupiter.api.Test
  void additionPositiveAndNegative() {
    // l: neg, r: pos
    int l = 20;
    int r = -30;
    assertEquals(-10, Calculator.addition(l, r));
  }

  @org.junit.jupiter.api.Test
  void additionZeros() {
    // l: 0, r: 0
    int l = 0;
    int r = 0;
    assertEquals(0, Calculator.addition(l, r));
  }

  // overflow
  @org.junit.jupiter.api.Test
  void additionOverflows() {
    int l = Integer.MAX_VALUE - 10;
    int r = Integer.MAX_VALUE - 10;
    try {
      Calculator.addition(l, r);
      fail( "My method didn't throw when I expected it to" );
    } catch (ArithmeticException e) {
    }
  }

  @org.junit.jupiter.api.AfterAll
  static void tearDownAll() {

  }
}