package Exam.Service;

import Exam.Model.BankAccount;
import Exam.Model.PaymentAccount;
import Exam.Model.SaveBankAccount;
import _12_Java_Collection_Framework.exersice.TestArrayListProduct.Model.Product;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class BankManager {
    ArrayList<BankAccount> listBankAccount = new ArrayList<>();

    public BankManager() {
    }
    Scanner scanner = new Scanner(System.in);
    public void add() {
        System.out.println("Chọn số tương ứng với loại tài khoản ngân hàng muốn thêm");
        System.out.println("1.Tài khoản tiết kiệm");
        System.out.println("2.Tài khoản thanh toán");
        int choose = scanner.nextInt();

        if (choose == 1) {
            System.out.println("nhập mã tài khoản");
            String accountID = scanner.nextLine();
            System.out.println("nhập tên tài khoản");
            String accountName = scanner.nextLine();
            Date createDate = new Date();
            int savingMoney = scanner.nextInt();
            Date savingDate = new Date();
            System.out.println("nhập lãi suất");
            float interest = scanner.nextFloat();
            System.out.println("nhập kỳ hạn");
            int period = scanner.nextInt();
            scanner.nextLine();
            SaveBankAccount saveBankAccount = new SaveBankAccount(accountID, accountName, createDate, savingMoney, savingDate, interest, period);
            listBankAccount.add(saveBankAccount);
            display();
        } else if (choose == 2) {
            System.out.println("nhập mã tài khoản");
            String accountID = scanner.nextLine();
            System.out.println("nhập tên tài khoản");
            String accountName = scanner.nextLine();
            Date createDate = new Date();
            System.out.println("nhập số thẻ");
            int accountNumber = scanner.nextInt();
            System.out.println("nhập số tiền tài khoản");
            int accountBalance = scanner.nextInt();
            scanner.nextLine();
            PaymentAccount paymentAccount = new PaymentAccount(accountID, accountName, createDate, accountNumber, accountBalance);
            listBankAccount.add(paymentAccount);
            display();
        } else System.out.println("Mời chọn lại");
    }
        public void deleteBankAccount(){
            System.out.println("mời nhập Mã tài khoản ngân hàng muốn xóa");
            String inputID = scanner.nextLine();
            scanner.nextLine();

            for (BankAccount bankAccount : listBankAccount) {
                if (inputID.equals(bankAccount.getAccountID())) {
                    System.out.println("Yes or No");
                    String choice=scanner.nextLine();
                    if(choice=="Yes"){
                    listBankAccount.remove(bankAccount);}
                    else System.out.println("mời chọn lại");
                }
            }
            display();
        }

    public void searchBankAccount(){
        System.out.println("mời nhập Mã tài khoản cần tìm");
        String inputID = scanner.nextLine();
        for (BankAccount bankAccount : listBankAccount) {
            if (inputID.equals(bankAccount.getAccountID())) {
                System.out.println(bankAccount.toString());
            }
        }
        display();
    }
    public void display(){
        for (BankAccount bankAccount : listBankAccount) {
            System.out.println(bankAccount.toString());
        }
    }
}
