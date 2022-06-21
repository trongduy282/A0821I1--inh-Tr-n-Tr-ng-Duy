package model.repository.impl;

import model.bean.Book;
import model.repository.IBookRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookRepository implements IBookRepository {
    private static final String SELECT_ALL_BOOKS = " select * from book ";

    @Override
    public boolean insertBook(Book book) throws SQLException {
//        System.out.println(INSERT_BOOK_RENTING);
//        Connection connection = BaseRepository.getConnect();
//        boolean check = false;
//        try {
//            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_BOOK_RENTING);
//            preparedStatement.setInt(1, customer.getCustomer_id());
//            preparedStatement.setInt(2, customer.getCustomer_type_id());
//            preparedStatement.setString(3, customer.getCustomer_name());
//            preparedStatement.setString(4, customer.getCustomer_birthday());
//            preparedStatement.setInt(5, customer.getCustomer_gender());
//            preparedStatement.setString(6, customer.getCustomer_id_card());
//            preparedStatement.setString(7, customer.getCustomer_phone());
//            preparedStatement.setString(8, customer.getCustomer_email());
//            preparedStatement.setString(9, customer.getCustomer_address());
//            check = preparedStatement.executeUpdate() > 0;
//            preparedStatement.close();
//            connection.close();
//            System.out.println(preparedStatement);
//            preparedStatement.executeUpdate();
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
        return false;
    }

    @Override
    public List<Book> getAllBook() {
        List<Book> bookList =new ArrayList<>();
        Connection connection = BaseRepository.getConnect();
        try {
            PreparedStatement ps = connection.prepareStatement(SELECT_ALL_BOOKS);
            System.out.println(ps);
            // Step 3: Execute the query or update query
            ResultSet rs = ps.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                String book_id = rs.getString("book_id");
                String book_name = rs.getString("book_name");
                String author_name = rs.getString("author_name");
                String des = rs.getString("des");
                int book_number = rs.getInt("book_number");
                bookList.add(new Book(book_id, book_name, author_name, des, book_number));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return bookList;
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
