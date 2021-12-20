package Exam.MainController;

import Exam.Service.BankManager;
import _12_Java_Collection_Framework.exersice.TestArrayListProduct.Service.ProductManager;

import java.util.Scanner;

public class MainController {
    public static void main(String[] args) {
        int choice;
        Scanner scanner = new Scanner(System.in);
        BankManager bankManager = new BankManager();
        while (true){
            System.out.println("--CHƯƠNG TRÌNH QUẢN LÝ TÀI KHOẢN NGÂN HÀNG –");
            System.out.println("Chọn chức năng theo số (để tiếp tục):");
            System.out.println("1.Thêm mới");
            System.out.println("2.Xóa");
            System.out.println("3.Xem danh sách các tài khoản ngân hàng");
            System.out.println("4.Tìm kiếm");
            System.out.println("5.Thoát");

            choice =scanner.nextInt();
            switch (choice){
                case 1: bankManager.add();break;
                case 2: bankManager.deleteBankAccount();break;
                case 3: bankManager.display();break;
                case 4: bankManager.searchBankAccount();break;
                case 5: System.exit(5);
            }
        }

    }
}
