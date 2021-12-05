package _15_Exception_java.exersice;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        float a, b, c;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập a: ");
        a = scanner.nextFloat();
        System.out.print("Nhập b: ");
        b = scanner.nextFloat();
        System.out.print("Nhập c: ");
        c = scanner.nextFloat();

        try {
            Triangle triangle = new Triangle(a, b, c);
        }
        catch (IllegalTriangleException e) {
            System.out.println(e);
        }
    }
}
