package Exam.Model;

import java.util.Date;

public class PaymentAccount extends BankAccount{
    private int accountNumber;
    private int accountBalance;

    public PaymentAccount() {
    }

    public PaymentAccount(String accountID, String accountName, Date createDate, int accountNumber, int accountBalance) {
        super(accountID, accountName, createDate);
        this.accountNumber = accountNumber;
        this.accountBalance = accountBalance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(int accountBalance) {
        this.accountBalance = accountBalance;
    }

    @Override
    public String toString() {
        return "PaymentAccount{" +
                "accountNumber=" + accountNumber +
                ", accountBalance=" + accountBalance +
                '}' + super.toString();
    }
}
