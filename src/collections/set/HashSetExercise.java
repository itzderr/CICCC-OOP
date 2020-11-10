package collections.set;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class HashSetExercise {

  public static void main(String[] args) {

    System.out.println(distinctYear(1987)); // 2013
    System.out.println(distinctYear(999)); // 1023
  }

  /**
   * Returns the next year with distinct digits
   * @param year int 0 <= year <= 10000
   * @return the next year with distinct digits
   */
  public static int distinctYear(int year) {
    int answer = year;
    for (int y = year + 1; y < 10235; y++) {
      String yearStr = String.valueOf(y);
      HashSet<Character> set = new HashSet<>();
      for (Character ch : yearStr.toCharArray()) {
        if (!set.add(ch)) {
          break;
        }
      }
      if (set.size() == yearStr.length()) {
        answer = Integer.parseInt(yearStr);
        break;
      }
    }
    return answer;
  }

  public static int distinctYearUsingStream(int year) {
    int answer = year + 1;
    for (int y = year + 1; y < 10235; y++) {
      String yearStr = String.valueOf(y);
      Set<Character> set = yearStr.chars().mapToObj(ch -> (char) ch).collect(Collectors.toSet());
      if (set.size() == yearStr.length()) {
        answer = Integer.parseInt(yearStr);
        break;
      }
    }
    return answer;
  }
}
