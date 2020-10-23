package oop.inheritence;

public class Driver {
    public static void main(String[] args) {
        // both method from own class and super class(has to be public) can be used

//        CheckingAccount b1 = new CheckingAccount(1, "a12345",100,200);
//        SavingsAccount s1 = new SavingsAccount(1, "s12345", 0, 5);
        BankAccount b1 = new BankAccount(1, "123", 0);
        BankAccount b2 = new BankAccount(1, "123", 0);

        // Object
        // when trying to print b1 -> oop.ingeritance.BankAccount@77459877
        // className + "@" + hexCode


    }
}

