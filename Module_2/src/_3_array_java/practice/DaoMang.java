package _3_array_java.practice;

import java.util.Scanner;

public class DaoMang {
    public static void main(String[] args) {
        System.out.println("Nhập vào số phần tử của mảng");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        while (n > 20) {
            System.out.println("vượt quá 20 mảng, mời nhập lại");
            n = scanner.nextInt();
        }
        int[] array = new int[n];
        for(int i=0;i<array.length;i++){
            System.out.println("nhập phần tử thứ " + (i+1) + ":");
            array[i]= scanner.nextInt();
        }
        System.out.printf("%-20s%s", "Elements in array: ", "");
        for (int j = 0; j < array.length; j++) {
            System.out.print(array[j] + "\t");
        }
        for(int j =0; j<array.length/2;j++){
            int temp =array[j];
            array[j]=array[array.length-1-j];
            array[array.length-1-j]=temp;
        }
        System.out.printf("\n%-20s%s", "Reverse array: ", "");
        for (int j = 0; j < array.length; j++) {
            System.out.print(array[j] + "\t");
        }
    }
}
