package _1_introduce_java.thuchanh;

import java.util.Scanner;

public class su_dung_toan_tu {
    public static void main(String[] args){
        float dai;
        float rong;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap chieu dai");
        dai = scanner.nextFloat();
        System.out.println("Nhap chieu rong");
        rong = scanner.nextFloat();
        float tich;
        tich =dai*rong;
        System.out.println(tich);
    }
}
