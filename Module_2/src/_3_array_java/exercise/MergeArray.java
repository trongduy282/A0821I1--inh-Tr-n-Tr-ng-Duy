package _3_array_java.exercise;

import java.util.Scanner;

public class MergeArray {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        int[] arr1 = new int[3];
        int[] arr2 = new int[5];
        for(int i = 0; i<arr1.length;i++){
            System.out.println("nhập giá trị phần tử thứ " + i + "của chuỗi 1");
            arr1[i]= scanner.nextInt();
        }
        for(int i = 0; i<arr2.length;i++){
            System.out.println("nhập giá trị phần tử thứ " + i + "của chuỗi 2");
            arr2[i]= scanner.nextInt();
        }

        for (int i = 0; i < arr1.length; i++) {
            System.out.println(arr1[i]);
        }
        for (int i = 0; i < arr2.length; i++) {
            System.out.println(arr2[i]);
        }
        int[] arr3 = new int[arr1.length+ arr2.length];
        int pos =0;
        for(int i = 0; i<arr1.length;i++){
         arr3[i]=arr1[i];
         pos++;
        }
        for (int i = 0; i < arr3.length; i++) {
            System.out.println(arr3[i]);
        }
        for(int i = 0; i<arr2.length;i++){
            arr3[pos]=arr2[i];
            pos++;
        }
        for (int i = 0; i < arr3.length; i++) {
            System.out.println(arr3[i]);
        }
    }
}
