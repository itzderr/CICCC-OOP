package oop.inheritence;

public class BankAccount {
    private int bankCode;
    private String accountNumber;
    private double balance;


    // method overloading
    public BankAccount(int bankCode, String accountNumber, double balance){
        this.bankCode = bankCode;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public BankAccount(int bankCode, String accountNumber) {
        this.bankCode = bankCode;
        this.accountNumber = accountNumber;
        this.balance = 0;
    }


    // getter method
    public int getBankCode(){
        return bankCode;
    }

    public String getAccountNumber(){
        return accountNumber;
    }

    public double getBalance(){
        return balance;
    }

    // setter method
    public void setBankCode(int bankCode){
        this.bankCode = bankCode;
    }

    public void setAccountNumber(String accountNumber){
        this.accountNumber = accountNumber;
    }

    public void setBalance(double balance){
        this.balance = balance;
    }


    // from Object class
    // toString(): returns the string representation of BankAccount (defined in the Object class)
    @Override // annotation (overwrite the definition of toString defined in Object class)
    public String toString(){
        return "BankAccount{accountNumber=" + accountNumber +
                ", bankCode=" + bankCode + ", balance=" + balance + "}";
    }

    @Override
    public boolean equals(Object o){
        if (this == o){    // (Check if Same reference)'this' refers to 'accountNumber', 'bankCode' and 'balance'
            return true;
        }
        if (o == null || this.getClass() != o.getClass()){  // get class of b1 and b2 (like 'Checking')
            return false;
        }
        BankAccount that = (BankAccount) o;  // that = O
        return accountNumber.equals(that.accountNumber)
                && bankCode == that.bankCode;
    }
}
