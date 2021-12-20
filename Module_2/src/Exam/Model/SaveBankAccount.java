package Exam.Model;

import java.util.Date;

public class SaveBankAccount extends BankAccount {
    private int savingMoney;
    private Date savingDate;
    private float interest;
    private int period;

    public SaveBankAccount() {
    }

    public SaveBankAccount(String accountID, String accountName, Date createDate, int savingMoney, Date savingDate, float interest, int period) {
        super(accountID, accountName, createDate);
        this.savingMoney = savingMoney;
        this.savingDate = savingDate;
        this.interest = interest;
        this.period = period;
    }

    public int getSavingMoney() {
        return savingMoney;
    }

    public void setSavingMoney(int savingMoney) {
        this.savingMoney = savingMoney;
    }

    public Date getSavingDate() {
        return savingDate;
    }

    public void setSavingDate(Date savingDate) {
        this.savingDate = savingDate;
    }

    public float getInterest() {
        return interest;
    }

    public void setInterest(float interest) {
        this.interest = interest;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    @Override
    public String toString() {
        return "SaveBankAccount{" +
                "savingMoney=" + savingMoney +
                ", savingDate=" + savingDate +
                ", interest=" + interest +
                ", period=" + period +
                '}' + super.toString();
    }
}
