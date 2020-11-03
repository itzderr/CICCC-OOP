package collections.list;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Stack;

public class StackExamples {
  public static void main(String[] args) {
    // Stack class is a legacy class (v1.0)
    Stack<String> s1 = new Stack<>();

    // v1.6 better stack (LIFO, or FILO)
    ArrayDeque<String> stack = new ArrayDeque<>();
    stack.push("Tenet");
    stack.push("Catch me if you can");
    stack.push("Forrest Gump");
    stack.push("Back to the future");
    stack.push("Star wars");
    stack.push("Home alone");
    System.out.println(stack.size());
    System.out.println(stack.isEmpty());
    System.out.println(stack.peek());

    while (!stack.isEmpty()) {
      System.out.println(stack.pop());
    }

    // checkBalance
    System.out.println(checkBalanceRefactored("if (a(4) > 9) { foo(a(2)); }"));
    System.out.println(checkBalanceRefactored("for  (i=0;i<(3};i++) { foo{)); )"));
    System.out.println(checkBalanceRefactored("if (x) {"));
  }

  /**
   * Write a function checkBalance that accepts a string of source code
   * and checks whether the braces/parentheses are balanced.
   * Every ( or { must be closed by a } or ) in the opposite order
   * Return the index at which an imbalance occurs, or -1 if balanced
   * If any ( or { are never closed, return the string’s length
   *
   * (Example)
   *   checkBalance(“if (a(4) > 9) { foo(a(2)); }”) returns -1
   *   checkBalance(“for  (i=0;i<(3};i++) { foo{)); )”) returns 14
   *   checkBalance(“if (x)  {”) returns 8
   */
  public static int checkBalance(String src) {
    // if "(", "{" -> push
    // if ")", "}" -> check if it's a matching pair, pop
    Deque<String> stack = new ArrayDeque<>();
    for (int i = 0; i < src.length(); i++) {
      if (src.substring(i, i + 1).equals("(") || src.substring(i, i + 1).equals("{")) {
        stack.push(src.substring(i, i + 1));
      } else if (src.substring(i, i + 1).equals(")") || src.substring(i, i + 1).equals("}")) {
        String open = stack.peek();
        if (open.equals("(")) {
          if (src.substring(i, i + 1).equals(")")) {
            stack.pop();
          } else {
            // not matching
            return i;
          }
        } else {
          if (src.substring(i, i + 1).equals("}")) {
            stack.pop();
          } else {
            // not matching
            return i;
          }
        }
      }
    }
    if (stack.isEmpty()) {
      return -1;
    } else {
      return src.length();
    }
  }

  public static int checkBalanceHashMap(String src) {
    // '{' : '}', '(' : ')'
    // HashMap is like a dictionary in Python
    HashMap<Character, Character> map = new HashMap<>();
    map.put('{', '}');
    map.put('(', ')');

    Deque<Character> stack = new ArrayDeque<>();
    for (int i = 0; i < src.length(); i++) {
      char ch = src.charAt(i);
      if (ch == '(' || ch == '{') {
        stack.push(ch);
      } else if (ch == ')' || ch == '}') {
        Character open = stack.peek();
        if (ch == map.get(open)) {
          stack.pop();
        } else {
          return i;
        }
      }
    }
    return stack.isEmpty() ? -1 : src.length();
  }

  public static int checkBalanceRefactored(String src) {
    Deque<Character> stack = new ArrayDeque<>();
    int length = src.length();
    for (int i = 0; i < length; i++) {
      char ch = src.charAt(i);
      switch (ch) {
        case '(':
        case '{':
          stack.push(ch);
          break;
        case ')':
          if (stack.isEmpty() || stack.pop() != '(') {
            return i;
          }
          break;
        case '}':
          if (stack.isEmpty() || stack.pop() != '{') {
            return i;
          }
          break;
        default:
          break;
      }
    }
    return stack.isEmpty() ? -1 : length;
  }
}
