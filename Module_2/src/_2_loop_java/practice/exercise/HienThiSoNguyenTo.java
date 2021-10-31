package _2_loop_java.practice.exercise;

import java.util.Scanner;

public class HienThiSoNguyenTo {
    public static void main(String[] args) {
        int number;
        Scanner scanner = new Scanner(System.in);
        System.out.println("nhap so luong so nguyen to");
        number = scanner.nextInt();
        int count = 0;
        int N = 2;
        boolean check;
        while (count < number) {
            check=true;
            for (int i = 2; i < N; i++) {
                if (N % i == 0) {
                    check= false;
                    break;
                }
            }
            if(check==true){
                System.out.println(N + " ");
                count++;
            }
            N++;
        }
    }
}
