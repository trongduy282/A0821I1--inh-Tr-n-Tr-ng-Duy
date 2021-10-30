package _2_loop_java.practice.practice;

import java.util.Scanner;

public class TienLaiChoVay {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("nhap so luong tien cho vay");
        double  tienchovay = scanner.nextDouble();
        System.out.println("nhap tỉ lệ lãi suất theo tháng");
        double tilelaithang = scanner.nextDouble();
        System.out.println("nhap số tháng cho vay");
        int sothangchovay = scanner.nextInt();
        double tienlai = 0;
        for(int i = 0; i < sothangchovay; i++){
            tienlai += tienchovay * (tilelaithang/100)/12 * sothangchovay;
        }
        System.out.println(tienlai);
    }
}
