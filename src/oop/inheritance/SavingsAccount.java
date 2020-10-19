package oop.inheritance;

public class SavingsAccount extends BankAccount {

  private int transactions;

  public SavingsAccount(int bankCode, String accountNumber, int balance, int transactions) {
    super(bankCode, accountNumber, balance);
    this.transactions = transactions;
  }

  public int getTransactions() {
    return transactions;
  }

  public void setTransactions(int transactions) {
    this.transactions = transactions;
  }
}
