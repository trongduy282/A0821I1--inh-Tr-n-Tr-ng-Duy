package _3_array_java.practice;

import java.util.Scanner;

public class DelArrayElement {
    public static void main(String[] args) {
        int[] arr = {10,4,6,7,8,6,0,0,1,1};
        System.out.println("nhập phần tử muốn xóa khỏi mảng");
        Scanner scanner =new Scanner(System.in);
        int n = scanner.nextInt();
        for(int i=0; i< arr.length; i++){
            if(n == arr[i]){
                for(int j= i; j<arr.length-1;j++){
                    arr[j]=arr[j+1];
                }
                }
            }
        for(int i=0; i< arr.length; i++){
            System.out.println(arr[i]);
        }
        }
    }

