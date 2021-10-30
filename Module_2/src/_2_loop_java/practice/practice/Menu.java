package _2_loop_java.practice.practice;

import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        int choice=-1;
        Scanner scanner = new Scanner(System.in);
        while (choice != 0) {
            System.out.println("Menu");
            System.out.println("Nhap so tuong ung de ve hinh");
            System.out.println("1. Tam Giac");
            System.out.println("2. Hinh Vuong");
            System.out.println("3. Hinh Chu Nhat");
            System.out.println("0. Thoat");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Tam Giac");
                    System.out.println("******");
                    System.out.println("*****");
                    System.out.println("****");
                    System.out.println("***");
                    System.out.println("**");
                    System.out.println("*");
                    break;
                case 2:
                    System.out.println("Hinh Vuong");
                    System.out.println("* * * * * *");
                    System.out.println("* * * * * *");
                    System.out.println("* * * * * *");
                    System.out.println("* * * * * *");
                    System.out.println("* * * * * *");
                    System.out.println("* * * * * *");
                    break;
                case 3:
                    System.out.println("Hinh Chu Nhat");
                    System.out.println("* * * * * *");
                    System.out.println("* * * * * *");
                    System.out.println("* * * * * *");
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("No choice!");
            }
        }
    }
}
