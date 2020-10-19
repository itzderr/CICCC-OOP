package oop.inheritance;

public class Driver {

  public static void main(String[] args) {
//        CheckingAccount b1 = new CheckingAccount(1, "a12345", 100, 200);
//        SavingsAccount s1 = new SavingsAccount(1, "s12345", 0, 5);

    BankAccount b1 = new BankAccount(1, "123", 0);
    BankAccount b2 = new BankAccount(1, "123", 0);
    // Object
    // oop.inheritance.BankAccount@77459877
    // className + "@" + hexCode
    System.out.println(b1);
    System.out.println(b2);

    // System.out.println(b1 == b2); // wrong
    System.out.println(b1.equals(b2));

    BankAccount c1 = new CheckingAccount(1, "123", 0, 100);
    BankAccount c3 = new SavingsAccount(1, "123", 0, 100);
    Object c2 = new CheckingAccount(1, "123", 0, 100);

    System.out.println(c1);
    System.out.println(c2);
    System.out.println(c1.equals(c2));
  }
}
