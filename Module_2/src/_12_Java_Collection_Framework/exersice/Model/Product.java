package _12_Java_Collection_Framework.exersice.Model;

public class Product {
    private int id;
    private String name;
    private int duration;
    private int price;

    public Product(int id, String name, int duration, int price) {
        this.id = id;
        this.name = name;
        this.duration = duration;
        this.price = price;
    }
    public Product() {

    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int year) {
        this.duration = year;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id= id;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", duration=" + duration +
                ", price=" + price +
                '}';
    }
}