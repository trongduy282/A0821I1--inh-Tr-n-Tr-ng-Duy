package model.repository;

import model.bean.Book;

import java.sql.SQLException;
import java.util.List;

public interface IBookRepository {
    public boolean insertBook(Book book) throws SQLException;
    List<Book> getAllBook();
    public Book selectBook(int id);
    public boolean deleteBook(int id) throws SQLException;
    public boolean updateBook(Book book) throws SQLException;
    List<Book> search(String nameSearch,String cardSearch,String addressSearch);
}
