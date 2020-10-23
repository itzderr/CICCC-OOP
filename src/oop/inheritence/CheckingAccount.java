package oop.inheritence;

public class CheckingAccount extends BankAccount{
    private long limit;

    public CheckingAccount(int bankCode, String accountNumber, int balance, long limit){
       // call the constructor from the super class(when there is a default constructor, this is not needed)
        super(bankCode, accountNumber, balance);
        this.limit = limit;
    }

    // getter (defined methods in super class can also be used for checking Account
    // in the driver even not defined here (= inherited)
    public long getLimit(){
        return limit;
    }

    // setter
    public void setLimit(long limit){
        this.limit = limit;
    }


}
