package Exam.Model;

import java.util.Date;

public abstract class BankAccount {
    private int id;
    private String accountID;
    private String accountName;
    private Date createDate;
    private static int increaseID=1;

    public BankAccount() {
    }

    public BankAccount(String accountID, String accountName, Date createDate) {
        this.id = increaseID++;
        this.accountID = accountID;
        this.accountName = accountName;
        this.createDate = createDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccountID() {
        return accountID;
    }

    public void setAccountID(String accountID) {
        this.accountID = accountID;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public static int getIncreaseID() {
        return increaseID;
    }

    public static void setIncreaseID(int increaseID) {
        BankAccount.increaseID = increaseID;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "id=" + id +
                ", accountID=" + accountID +
                ", accountName='" + accountName + '\'' +
                ", createDate=" + createDate +
                '}';
    }
}
