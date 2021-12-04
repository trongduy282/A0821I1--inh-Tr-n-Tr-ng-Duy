package _12_Java_Collection_Framework.exersice.TestArrayListProduct.Service;

import _12_Java_Collection_Framework.exersice.TestArrayListProduct.Model.Product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ProductManager {
    ArrayList<Product> listProduct = new ArrayList<>();

    public ProductManager() {
    }
    Scanner scanner =new Scanner(System.in);
    public void add(){
        System.out.println("nhập tên sản phẩm");
        String name = scanner.nextLine();
        System.out.println("nhập giá sản phẩm");
        int price = scanner.nextInt();
        scanner.nextLine();
        Product product = new Product(name,price);
        listProduct.add(product);
        display();
    }

    public void edit(){
        System.out.println("mời nhập ID cần chỉnh sửa");
        int inputID = scanner.nextInt();
        scanner.nextLine();
        for (Product product : listProduct) {
            if (inputID == product.getId()) {
                System.out.println("Nhập tên sản phẩm mới");
                product.setName(scanner.nextLine());
                System.out.println("Nhập giá sản phẩm mới");
                product.setPrice(scanner.nextInt());

            }
        }
        display();
    }
public void deleteProduct(){
    System.out.println("mời nhập ID cần xóa");
    int inputID = scanner.nextInt();
    scanner.nextLine();
    for (Product product : listProduct) {
        if (inputID == product.getId()) {
            listProduct.remove(product);
        }
    }
    display();
}

public void searchProduct(){
    System.out.println("mời nhập tên sản phẩm cần tìm");
    String inputName = scanner.nextLine();
    for (Product product : listProduct) {
        if (inputName.equals(product.getName())) {
            System.out.println(product.toString());
        }
    }

//    for(int i=0;i<listProduct.size();i++){
//        if(listProduct.equals(inputName)){
//            System.out.println(listProduct.toString());
//        }
//    }
    display();
}
public void sortIncease(){
    Collections.sort(listProduct,new SortPriceIncrease());
    display();
}
    public void sortDecrease(){
        Collections.sort(listProduct,new SortPriceDecrease());
        display();
    }
    public void display(){
        for (Product product : listProduct) {
            System.out.println(product.getName()+ " "+ product.getId() + " " +product.getPrice());
        }
    }
}
