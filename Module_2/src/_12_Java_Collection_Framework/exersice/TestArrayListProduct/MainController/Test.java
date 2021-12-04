package _12_Java_Collection_Framework.exersice.TestArrayListProduct.MainController;

import _12_Java_Collection_Framework.exersice.TestArrayListProduct.Model.Product;
import _12_Java_Collection_Framework.exersice.TestArrayListProduct.Service.ProductManager;
import _12_Java_Collection_Framework.practice.Student;

public class Test {
    public static void main(String[] args) {
        ProductManager testProduct = new ProductManager();
        testProduct.add();
        testProduct.add();
        testProduct.add();
        testProduct.display();
        testProduct.sortIncease();
        testProduct.display();
        //testProduct.searchProduct();

    }
}
