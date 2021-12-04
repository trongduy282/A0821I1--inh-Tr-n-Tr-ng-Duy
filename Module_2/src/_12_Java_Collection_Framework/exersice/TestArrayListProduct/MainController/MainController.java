package _12_Java_Collection_Framework.exersice.TestArrayListProduct.MainController;

import _12_Java_Collection_Framework.exersice.TestArrayListProduct.Service.ProductManager;

import java.util.Scanner;

public class MainController {
    public static void main(String[] args) {
        int choice;
        Scanner scanner = new Scanner(System.in);
        ProductManager productManager = new ProductManager();
        while (true){
                System.out.println("Menu");
                System.out.println("Mời chọn chức năng");
                System.out.println("1.Thêm sản phẩm");
                System.out.println("2.Sửa sản phẩm theo ID");
                System.out.println("3.Xóa sản phẩm");
                System.out.println("4.Hiển thị danh sách sản phẩm");
                System.out.println("5.Tìm kiếm sản phẩm");
                System.out.println("6.Sắp xếp tăng dần");
                System.out.println("7.Sắp xếp giảm dần");
                System.out.println("8.Thoát");
                System.out.println("MỜI BẠN CHỌN;");
            choice =scanner.nextInt();
                switch (choice){
                    case 1: productManager.add();break;
                    case 2: productManager.edit();break;
                    case 3: productManager.deleteProduct();break;
                    case 4: productManager.display();break;
                    case 5: productManager.searchProduct();break;
                    case 6: productManager.sortIncease();break;
                    case 7: productManager.sortDecrease();break;
                    case 8: System.exit(8);
                }
            }

    }
}
