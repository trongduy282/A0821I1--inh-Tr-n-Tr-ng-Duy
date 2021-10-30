package _1_introduce_java.exercise;

import java.util.Scanner;
//CHUA LAM DUOC
public class SoThanhChu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap so can doc");
        int so = scanner.nextInt();
        if(so>=0 && so<10){
            switch (so){
                case 0: System.out.println("khong");break;
                case 1: System.out.println("mot");break;
                case 2: System.out.println("hai");break;
                case 3: System.out.println("ba");break;
                case 4: System.out.println("bon");break;
                case 5: System.out.println("nam");break;
                case 6: System.out.println("sau");break;
                case 7: System.out.println("bay");break;
                case 8: System.out.println("tam");break;
                case 9: System.out.println("chin");break;
                default: System.out.println("out of ability");break;
            }
        }else if(so>=10 && so<20){
            int donvi= so-10;
            switch (donvi){
                case 0: System.out.println("khong");break;
                case 1: System.out.println("mot");break;
                case 2: System.out.println("hai");break;
                case 3: System.out.println("ba");break;
                case 4: System.out.println("bon");break;
                case 5: System.out.println("nam");break;
                case 6: System.out.println("sau");break;
                case 7: System.out.println("bay");break;
                case 8: System.out.println("tam");break;
                case 9: System.out.println("chin");break;
                default: System.out.println("out of ability");break;
            }
        }
    }
}
