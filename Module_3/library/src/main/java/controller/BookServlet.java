package controller;

import model.bean.Book;
import model.bean.Book_renting;
import model.service.IBookService;
import model.service.impl.BookService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "BookServlet", urlPatterns = "/book")
public class BookServlet extends HttpServlet {
    IBookService bookService = new BookService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                // trả về một form để điền dữ liệu
                showNewForm(request, response);
                // code thêm mới
                break;
            case "edit":
//                try {
////                    showEditForm(request, response);
//                } catch (SQLException throwables) {
//                    throwables.printStackTrace();
//                }
                // chỉnh sửa
                break;
            case "delete":
//                try {
//                    deleteUser(request, response);
//                } catch (SQLException throwables) {
//                    throwables.printStackTrace();
//                }
                break;
            case "search":
//                search(request,response);
                break;
            // xóa
            default:
                // trả về trang list
                showListBook(request, response);

        }
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/book/create.jsp");
        dispatcher.forward(request, response);
    }

    private void showListBook(HttpServletRequest request, HttpServletResponse response) {
        List<Book> bookList = bookService.getAllBook();
        request.setAttribute("bookList", bookList);
//        request.setAttribute("subjectList",subjectService.getAllSubject());
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/book/list.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
//                try {
//                    insertCustomer(request, response);
//                } catch (SQLException throwables) {
//                    throwables.printStackTrace();
//                }
                // lưu dữ liệu
                try {
                    save(request,response);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
            case "edit":
//                try {
//                    updateUser(request, response);
//                } catch (SQLException throwables) {
//                    throwables.printStackTrace();
//                }
                // chỉnh sửa
                break;
            case "delete":
                // xóa
            default:

        }
    }

    private void save(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
//            String renting_id = request.getParameter("renting_id");
//            String book_name = request.getParameter("book_name");
//            String student_name = request.getParameter("student_name");
//            String rental_day = request.getParameter("rental_day"));
//            String return_day = request.getParameter("return_day");
//            Book_renting newBook_renting = new Book_renting(renting_id,book_name, student_name, rental_day, return_day);
//            boolean check  = customerService.insertCustomer(newCustomer);
//            if (check ==  true)
//            {
//                request.setAttribute("mess","thêm mới thành công");
//                RequestDispatcher dispatcher = request.getRequestDispatcher("view/customer/create.jsp");
//                dispatcher.forward(request, response);
//            }
//            else
//            {
//                request.setAttribute("mess","thêm mới thất bại");
//                RequestDispatcher dispatcher = request.getRequestDispatcher("view/customer/create.jsp");
//                dispatcher.forward(request, response);
            }
    }

