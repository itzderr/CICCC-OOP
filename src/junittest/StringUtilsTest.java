package junittest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("A special test case for StringUtils")
class StringUtilsTest {

  @BeforeEach
  void setUp() {
  }

  @AfterEach
  void tearDown() {
  }

  @ParameterizedTest
  @ValueSource(strings = { "racecar", "radar", "able was I ere I saw elba" })
  @DisplayName("😏")
  void palindromes(String candidate) {
    assertTrue(StringUtils.palindromes(candidate));
  }

  @ParameterizedTest
  @ValueSource(strings = { "abcde", "abbc", "aable was I ere I saw elba" })
  @DisplayName("😱")
  void palindromesFalse(String candidate) {
    assertFalse(StringUtils.palindromes(candidate));
  }
}