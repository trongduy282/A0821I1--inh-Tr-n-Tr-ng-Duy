package _1_introduce_java.exercise;

import java.util.Scanner;

public class HelloGreeting {
public static void main(String[] args){
    System.out.println("Enter Your Name: ");
    Scanner scanner = new Scanner(System.in);
    String name = scanner.nextLine();
    System.out.println("Hello " + name);
}
}
