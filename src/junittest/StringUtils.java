package junittest;

public class StringUtils {
  public static boolean palindromes(String candidate) {
    char[] chars = candidate.toCharArray();
    for (int i = 0; i < chars.length / 2; i++) {
      if (chars[i] != chars[chars.length - 1 - i]) {
        return false;
      }
    }
    return true;
  }
}
