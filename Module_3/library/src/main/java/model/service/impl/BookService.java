package model.service.impl;

import model.bean.Book;
import model.repository.IBookRepository;
import model.repository.impl.BookRepository;
import model.service.IBookService;

import java.sql.SQLException;
import java.util.List;

public class BookService implements IBookService {
    IBookRepository bookRepository = new BookRepository();
    @Override
    public boolean insertBook(Book book) throws SQLException {
        return false;
    }

    @Override
    public List<Book> getAllBook() {
        return bookRepository.getAllBook();
    }

    @Override
    public Book selectBook(int id) {
        return null;
    }

    @Override
    public boolean deleteBook(int id) throws SQLException {
        return false;
    }

    @Override
    public boolean updateBook(Book book) throws SQLException {
        return false;
    }

    @Override
    public List<Book> search(String nameSearch, String cardSearch, String addressSearch) {
        return null;
    }
}
