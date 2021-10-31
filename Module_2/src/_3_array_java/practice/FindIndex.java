package _3_array_java.practice;

import java.util.Scanner;

public class FindIndex {
    public static void main(String[] args) {
String[] arr = {"Duy","Toan","Thu","Quoc"};
        System.out.println("nhập tên muốn tìm");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        boolean check = false;
        for(int i = 0; i< arr.length; i++){
            if(name.equals(arr[i])){
                System.out.println(name + " ở vị tri thứ " + i);
                check = true;
                break;
            }
        }if(!check) {System.out.println("Không có tên cần tìm");}
    }
}
