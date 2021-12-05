package _15_Exception_java.practice;

import java.util.Scanner;

public class CalculationExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap x:");
        int x = scanner.nextInt();
        System.out.println("Nhap y:");
        int y = scanner.nextInt();
        CalculationExample calc = new CalculationExample();
        calc.calculate(x,y);
    }

    public void calculate(int x, int y) {
        try{
            int a = x + y;
            int b = x - y;
            int c = x * y;
            int d = x / y;
            System.out.println("Tổng x + y = " + a);
            System.out.println("Hiệu x - y = " + b);
            System.out.println("Tích x * y = " + c);
            System.out.println("Thương x / y = " + d);
        } catch (NumberFormatException e){
            System.err.println("Xảy ra ngoại lệ: " + e.getMessage());
        }
    }
}
