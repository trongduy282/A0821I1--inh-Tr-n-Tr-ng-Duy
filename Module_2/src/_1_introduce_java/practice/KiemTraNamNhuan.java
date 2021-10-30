package _1_introduce_java.practice;

import java.util.Scanner;

public class KiemTraNamNhuan {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap nam");
        int nam = scanner.nextInt();

        if(nam % 4 ==0){
            if(nam % 100==0){
                if(nam % 400 == 0){
                    System.out.printf("%d la nam nhuan", nam);
                }else {
                    System.out.printf("%d KO la nam nhuan",nam);
                }
            }else {
                System.out.printf("%d la nam nhuan", nam);
            }
        }else {
            System.out.printf("%d KO la nam nhuan", nam);
        }
    }
}
