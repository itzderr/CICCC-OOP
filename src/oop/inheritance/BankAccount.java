package oop.inheritance;


public class BankAccount {
  private int bankCode;
  private String accountNumber;
  protected double balance;

  // method overloading
  public BankAccount(int bankCode, String accountNumber, double balance) {
    this.bankCode = bankCode;
    this.accountNumber = accountNumber;
    this.balance = balance;
  }

  public BankAccount(int bankCode, String accountNumber) {
    this.bankCode = bankCode;
    this.accountNumber = accountNumber;
    this.balance = 0;
  }

  public int getBankCode() {
    return bankCode;
  }

  public String getAccountNumber() {
    return accountNumber;
  }

  public double getBalance() {
    return balance;
  }

  public void setBankCode(int bankCode) {
    this.bankCode = bankCode;
  }

  public void setAccountNumber(String accountNumber) {
    this.accountNumber = accountNumber;
  }

  public void setBalance(double balance) {
    this.balance = balance;
  }

  // from Object class
  // toString() : returns the string representation of BankAccount
  @Override  // annotation
  public String toString() {
    return "BankAccount{accountNumber=" + accountNumber +
        ", bankCode=" + bankCode + ", balance=" + balance + "}";
  }

  @Override
  public boolean equals(Object o) {
      if (this == o) {
          return true;
      }
      if (o == null || getClass() != o.getClass()) {
          return false;
      }
    BankAccount that = (BankAccount) o;
    return accountNumber.equals(that.accountNumber)
        && bankCode == that.bankCode;
  }
}

