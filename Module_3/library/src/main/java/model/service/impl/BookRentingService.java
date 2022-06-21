package model.service.impl;

import model.bean.Book;
import model.bean.Book_renting;
import model.repository.IBookRentingRepository;
import model.repository.IBookRepository;
import model.repository.impl.BookRentingRepository;
import model.repository.impl.BookRepository;
import model.service.IBookRentingService;

import java.sql.SQLException;
import java.util.List;

public class BookRentingService implements IBookRentingService {
    IBookRentingRepository bookRentingRepository = new BookRentingRepository();
    @Override
    public boolean insertBookRenting(Book_renting book_renting) throws SQLException {
        return false;
    }

    @Override
    public List<Book_renting> getAllBook_renting() {
        return bookRentingRepository.getAllBook_renting();
    }

    @Override
    public Book_renting selectBook_renting(int id) {
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
    public List<Book_renting> search(String bookNameSearch, String studentNameSearch) {
        return null;
    }
}
