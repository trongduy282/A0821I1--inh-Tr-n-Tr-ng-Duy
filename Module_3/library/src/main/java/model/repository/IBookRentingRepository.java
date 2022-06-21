package model.repository;

import model.bean.Book;
import model.bean.Book_renting;

import java.sql.SQLException;
import java.util.List;

public interface IBookRentingRepository {
    public boolean insertBookRenting(Book_renting book_renting) throws SQLException;
    List<Book_renting> getAllBook_renting();
    public Book_renting selectBook_renting(int id);
    public boolean deleteBook(int id) throws SQLException;
    public boolean updateBook(Book book) throws SQLException;
    List<Book_renting> search(String bookNameSearch,String studentNameSearch);
}
