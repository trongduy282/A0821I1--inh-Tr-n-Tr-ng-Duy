package model.bean;

public class Product {
    private int id;
    private String name;
    private int price;
    private String des;
    private String manu;

    public Product() {
    }
    public Product(int id, String name, int price, String des, String manu) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.des = des;
        this.manu = manu;
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

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getManu() {
        return manu;
    }

    public void setManu(String manu) {
        this.manu = manu;
    }
}

