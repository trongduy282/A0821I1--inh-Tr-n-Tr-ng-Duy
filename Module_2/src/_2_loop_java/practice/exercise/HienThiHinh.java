package _2_loop_java.practice.exercise;

import java.util.Scanner;

public class HienThiHinh {
    public static void main(String[] args) {
        int choice=-1;
        Scanner scanner = new Scanner(System.in);
        while (choice != 4) {
            System.out.println("Menu");
            System.out.println("Nhap so tuong ung de ve hinh");
            System.out.println("1. Print the rectangle");
            System.out.println("2. Print the square triangle (The corner is square at 4 different angles: top-left, top-right, botton-left, botton-right)");
            System.out.println("3. Print isosceles triangle");
            System.out.println("4. Exit");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("nhap chieu rong");
                    int rong = scanner.nextInt();
                    System.out.println("nhap chieu dai");
                    int dai = scanner.nextInt();
                    for (int i =1; i<=dai; i++){
                        for(int j = 1; j<=rong; j++){
                            System.out.print("* ");
                        }System.out.print("");
                        }
                    break;
                case 2:
                    System.out.println("nhap chieu dai");
                    int x = scanner.nextInt();
                    System.out.println("nhap sao");
                    int y = scanner.nextInt();
                    for (int i =1; i<=x; i++){
                        for(int j = 1; j<=y; j++){
                            System.out.print("* ");
                        }System.out.print("");
                    }
                    for (int i =x; i>=1; i--){
                        for(int j = 1; j<=y; j++){
                            System.out.print("* ");
                        }System.out.print("");
                    }
                    break;

                case 3:
                    System.out.println("nhap chieu cao");
                    int cao = scanner.nextInt();
                    //i=5 => j =2*i-1
                    for (int i = 1; i <= cao; i++) {
                        for (int j = 1; j <= cao - i; j++) {
                            System.out.print(" ");
                        }
                        for (int k = 1; k <= 2 * i - 1; k++) {
                            System.out.print("*");
                        }
                        System.out.println("");
                    }
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("No choice!");
            }
        }
    }
    }
