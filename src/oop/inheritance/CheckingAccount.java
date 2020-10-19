package oop.inheritance;

public class CheckingAccount extends BankAccount {

  private long limit;

  public CheckingAccount(int bankCode, String accountNumber, int balance, long limit) {
    super(bankCode, accountNumber, balance);
    this.limit = limit;
  }

  public long getLimit() {
    return limit;
  }

  public void setLimit(long limit) {
    this.limit = limit;
  }
}
