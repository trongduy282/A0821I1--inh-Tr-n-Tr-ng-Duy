package model.bean;

public class Book {
    private String book_id;
    private String book_name;
    private String author_name;
    private String des;
    private int book_number;

    public Book() {
    }

    public Book(String book_id, String book_name, String author_name, String des, int book_number) {
        this.book_id = book_id;
        this.book_name = book_name;
        this.author_name = author_name;
        this.des = des;
        this.book_number = book_number;
    }

    public String getBook_id() {
        return book_id;
    }

    public void setBook_id(String book_id) {
        this.book_id = book_id;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public String getAuthor_name() {
        return author_name;
    }

    public void setAuthor_name(String author_name) {
        this.author_name = author_name;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public int getBook_number() {
        return book_number;
    }

    public void setBook_number(int book_number) {
        this.book_number = book_number;
    }
}
