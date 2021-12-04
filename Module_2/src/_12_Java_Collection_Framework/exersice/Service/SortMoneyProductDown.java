package _12_Java_Collection_Framework.exersice.Service;

import _12_Java_Collection_Framework.exersice.Model.Product;

import java.util.Comparator;

public class SortMoneyProductDown implements Comparator<Product> {

    //hàm sort hai trường price,name.
    @Override
    public int compare(Product o1, Product o2) {
        if(o1.getPrice() == o2.getPrice()) {
            return o1.getName().compareTo(o2.getName());
        }
        return o2.getPrice() - o1.getPrice();
    }
}
