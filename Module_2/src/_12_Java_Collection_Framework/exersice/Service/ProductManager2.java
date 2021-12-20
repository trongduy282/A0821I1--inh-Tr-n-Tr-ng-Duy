package _12_Java_Collection_Framework.exersice.Service;

import _12_Java_Collection_Framework.exersice.Model.Product2;

import java.util.ArrayList;
import java.util.Scanner;

public class ProductManager2 {
    ArrayList<Product2> arrayListProduct2 = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public ProductManager2() {
    }

    public void add() {
        System.out.println("mời nhập tên sản phẩm");
        String name = scanner.nextLine();
        System.out.println("mời nhập giá sản phẩm");
        int price = scanner.nextInt();
        scanner.nextLine();
        Product2 product2 = new Product2(name,price);
        arrayListProduct2.add(product2);
        display();
    }


    public void display(){
        for (Product2 product2 : arrayListProduct2) {
            System.out.println(product2);
        }
    }
}
