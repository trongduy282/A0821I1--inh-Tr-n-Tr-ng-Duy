package _3_array_java.exercise;

import java.util.Scanner;

public class AddArrayElement {
    public static void main(String[] args) {
        int[] arr =new int[10];
        int n=5;
        for (int i=0;i< n; i++) {
            arr[i] = i + 1;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        System.out.println("nhập phần tử muốn chèn");
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        System.out.println("nhập vị trí muốn chèn");
        int index = scanner.nextInt();

        for (int j = n; j > index; j--) {
            arr[j] = arr[j - 1];
        }
        arr[index] = x;
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
