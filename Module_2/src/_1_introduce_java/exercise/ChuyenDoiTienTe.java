package _1_introduce_java.exercise;

import java.util.Scanner;

public class ChuyenDoiTienTe {
    public static void main(String[] args) {
        int rate = 23000;
        System.out.println("ty gia la 23000");
        Scanner scanner = new Scanner(System.in);
        System.out.println("nhap USD can chuyen doi");
        int usd = scanner.nextInt();
        int chuyendoi = usd*rate;
        System.out.println("Doi ra tien Viet la " + chuyendoi);
    }
}
