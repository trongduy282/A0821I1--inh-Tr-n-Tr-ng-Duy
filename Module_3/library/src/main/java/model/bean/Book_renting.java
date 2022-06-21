package model.bean;

public class Book_renting {
    private int renting_id;
    private String book_id;
    private int student_id;
    private Boolean status;
    private String rental_day;
    private String return_day;

    public Book_renting() {
    }

    public Book_renting(int renting_id, String book_id, int student_id, Boolean status, String rental_day, String return_day) {
        this.renting_id = renting_id;
        this.book_id = book_id;
        this.student_id = student_id;
        this.status = status;
        this.rental_day = rental_day;
        this.return_day = return_day;
    }

    public int getRenting_id() {
        return renting_id;
    }

    public void setRenting_id(int renting_id) {
        this.renting_id = renting_id;
    }

    public String getBook_id() {
        return book_id;
    }

    public void setBook_id(String book_id) {
        this.book_id = book_id;
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getRental_day() {
        return rental_day;
    }

    public void setRental_day(String rental_day) {
        this.rental_day = rental_day;
    }

    public String getReturn_day() {
        return return_day;
    }

    public void setReturn_day(String return_day) {
        this.return_day = return_day;
    }
}
