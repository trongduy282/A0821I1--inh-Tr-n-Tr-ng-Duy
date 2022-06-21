package controller;

import model.bean.Book;
import model.bean.Book_renting;
import model.service.IBookRentingService;
import model.service.IBookService;
import model.service.impl.BookRentingService;
import model.service.impl.BookService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "BookRentingServlet", value = "/BookRentingServlet")
public class BookRentingServlet extends HttpServlet {
    IBookRentingService bookRentingService = new BookRentingService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
//                // trả về một form để điền dữ liệu
//                showNewForm(request, response);
//                // code thêm mới
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
                showListBookRenting(request, response);

        }
    }

    private void showListBookRenting(HttpServletRequest request, HttpServletResponse response) {
        List<Book_renting> book_rentingList = bookRentingService.getAllBook_renting();
        request.setAttribute("book_rentingList", book_rentingList);
//        request.setAttribute("subjectList",subjectService.getAllSubject());
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/book_renting/listbookrenting.jsp");
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
//                try {
//                    save(request,response);
//                } catch (SQLException throwables) {
//                    throwables.printStackTrace();
//                }
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
}
