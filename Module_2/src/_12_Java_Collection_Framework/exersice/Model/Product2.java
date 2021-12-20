package _12_Java_Collection_Framework.exersice.Model;

public class Product2 {
    private int id;
    private String name;
    private int price;
    private static  int increaseID=1;
    public Product2() {
    }

    public Product2(String name, int price) {
        this.id = increaseID++;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product2{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
