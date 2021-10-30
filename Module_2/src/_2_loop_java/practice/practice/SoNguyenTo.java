package _2_loop_java.practice.practice;

import java.util.Scanner;

public class SoNguyenTo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("nhap so can kiem tra");
        int n = scanner.nextInt();
        if(n<2){
            System.out.println(n + " khong phai la so nguyen to");
        } else {
            int i=2;
            boolean check = true;
            while (i <= Math.sqrt(n)){
                if(n%i==0){
                    check =false;
                    break;
                }
                i++;
            }
            if(check){
                System.out.println(n + " la so nguyen to");
            }else {
                System.out.println(n + " KO la so nguyen to");
        }

        }
    }
}
