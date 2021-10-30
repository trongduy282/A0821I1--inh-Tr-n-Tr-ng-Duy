package _1_introduce_java.thuchanh;

import java.util.Scanner;

public class giai_phuong_trinh_bac_nhat {
    public static void main(String[] args) {
        System.out.println("Giai phuong trinh bac nhat");
        System.out.println("Given a equation as 'a * x + b = c', please enter constants:");
        Scanner scanner = new Scanner(System.in);

        System.out.println("nhap a");
        double a = scanner.nextDouble();

        System.out.println("nhap b");
        double b = scanner.nextDouble();

        System.out.println("nhap c");
        double c = scanner.nextDouble();

        if (a != 0) {
            double x = (c - b) / a;
            System.out.printf("x bang %f!\n", x);
        } else {
            if (b == c) {
                System.out.print("The solution is all x!");
            } else {
                System.out.print("No solution!");
            }
        }
    }
}
