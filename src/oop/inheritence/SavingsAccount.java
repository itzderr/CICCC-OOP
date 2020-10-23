package oop.inheritence;

public class SavingsAccount extends BankAccount {
    private int transactions;

    public SavingsAccount(int bankCode, String accountNumber, int balance, int transactions ){
        super(bankCode, accountNumber, balance);
        this.transactions = transactions;
    }
    // getter
    public int getTransactions(){
        return transactions;
    }

    // setter
    public void setTransactions(int transactions){
        this.transactions = transactions;
    }

}
