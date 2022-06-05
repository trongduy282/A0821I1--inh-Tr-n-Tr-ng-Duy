package controller;

import model.bean.User;
import model.service.IUserService;
import model.service.impl.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "UserServlet", urlPatterns = "/user")
public class UserServlet extends HttpServlet {
    IUserService userService = new UserService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showNewForm(request, response);
                // tra ve 1 form de dien du lieu
                // code thêm mới
                break;
            case "edit":
                try {
                    showEditForm(request, response);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                // chỉnh sửa
                break;
            case "delete":
                try {
                    deleteUser(request, response);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                // xóa
                break;
            case "search":
                searchProduct(request,response);
                break;
            default:
                // tra ve trang list
                showListUser(request, response);
        }
    }

    private void searchProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        String countryName = request.getParameter("countryName");
        List<User> userList = userService.findByCountry(countryName);

        RequestDispatcher dispatcher;
        if(userList==null) {
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        }else {
            request.setAttribute("userList",userList);
            dispatcher = request.getRequestDispatcher("view/user/list.jsp");
        }
        dispatcher.forward(request,response);
    }

    private void deleteUser(HttpServletRequest request, HttpServletResponse response)   throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        userService.deleteUser(id);

        List<User> userList = userService.selectAllUsers();
        request.setAttribute("userList", userList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/user/list.jsp");
        dispatcher.forward(request, response);
    }


    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        User existingUser = userService.selectUser(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/user/edit.jsp");
        request.setAttribute("user", existingUser);
        dispatcher.forward(request, response);

    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/user/create.jsp");
        dispatcher.forward(request, response);
    }

    private void showListUser(HttpServletRequest request, HttpServletResponse response) {
        List<User> userList = userService.selectAllUsers();
        request.setAttribute("userList", userList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/user/list.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
        protected void doPost (HttpServletRequest request, HttpServletResponse response) throws
        ServletException, IOException {
            String action = request.getParameter("action");
            if (action == null) {
                action = "";
            }
            switch (action) {
                case "create":
                    try {
                        insertUser(request, response);
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                    // lưu dữ liệu

                    break;
                case "edit":
                    try {
                        updateUser(request, response);
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                    // chỉnh sửa
                    break;
                case "delete":
                    // xóa
                default:


            }
        }

    private void updateUser(HttpServletRequest request, HttpServletResponse response)  throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");

        User book = new User(id, name, email, country);
        userService.updateUser(book);
        request.setAttribute("mess","chỉnh sửa thành công");
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/user/edit.jsp");
        dispatcher.forward(request, response);
    }

    private void insertUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");
        User newUser = new User(name, email, country);
        userService.insertUser(newUser);
        request.setAttribute("mess","thêm mới thành công");
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/user/create.jsp");
        dispatcher.forward(request, response);
    }
}