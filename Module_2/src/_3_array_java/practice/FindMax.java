package _3_array_java.practice;

import java.util.Scanner;

public class FindMax {
    public static void main(String[] args) {
        int[] taisan;
        int n;
        System.out.println("Nhap so luong ty phu");
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        while (n > 20) {
            System.out.println("vượt quá 20 mảng, mời nhập lại");
            n = scanner.nextInt();
        }
        taisan = new int[n];
        for(int i =0; i<taisan.length;i++){
            System.out.println("nhap gia tri tai san thư " + (i+1));
            taisan[i]= scanner.nextInt();
        }
        System.out.print("Property list: ");
        for (int j = 0; j < taisan.length; j++) {
            System.out.print(taisan[j] + "\t");
        }
        int max=taisan[0];
        int index=0;
        for (int j = 0; j < taisan.length; j++) {
            if (taisan[j] > max) {
                max = taisan[j];
                index =j;
            }
        }
        System.out.println("max là :" + max + " ở vị trí " + index);
    }
}
