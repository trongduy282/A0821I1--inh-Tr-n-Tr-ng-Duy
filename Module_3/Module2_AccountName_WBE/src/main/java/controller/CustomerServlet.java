package controller;

import model.bean.Customer;
import model.service.ICustomerService;
import model.service.impl.CustomerService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "CustomerServlet", urlPatterns = "/customer")
public class CustomerServlet extends HttpServlet {
    ICustomerService customerService = new CustomerService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action==null){
            action ="";
        }
        switch (action){
            case "create":
                // trả về một form để điền dữ liệu
                showNewForm(request, response);
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
                break;
            case "search":
                search(request,response);
                break;
                // xóa
            default:
                // trả về trang list
                showListCustomer(request,response);


        }
    }

    private void search(HttpServletRequest request, HttpServletResponse response) {
        String nameSearch = request.getParameter("nameSearch");
        String cardSearch = request.getParameter("cardSearch");
        String addressSearch = request.getParameter("addressSearch");
        List<Customer> customerList = customerService.search(nameSearch,cardSearch,addressSearch);
        request.setAttribute("customerList", customerList);
//        request.setAttribute("classList", classCGList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/customer/list.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        customerService.deleteCustomer(id);

        List<Customer> customerList = customerService.getAllCustomer();
        request.setAttribute("customerList", customerList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/customer/list.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Customer existingCustomer = customerService.selectCustomer(id);
        request.setAttribute("customer",existingCustomer);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/customer/edit.jsp");
        request.setAttribute("customer", existingCustomer);
        dispatcher.forward(request, response);

    }

    private void showListCustomer(HttpServletRequest request, HttpServletResponse response) {
        List<Customer> customerList = customerService.getAllCustomer();
        request.setAttribute("customerList", customerList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/customer/list.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/customer/create.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action==null){
            action ="";
        }
        switch (action){
            case "create":
                try {
                    insertCustomer(request, response);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                // lưu dữ liệu
//                save(request,response);
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

    private void updateUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int customer_id = Integer.parseInt(request.getParameter("customer_id"));
        int customer_type_id = Integer.parseInt(request.getParameter("customer_type_id"));
        String customer_name = request.getParameter("customer_name");
        String customer_birthday = request.getParameter("customer_birthday");
        int customer_gender = Integer.parseInt(request.getParameter("customer_gender"));
        String customer_id_card = request.getParameter("customer_id_card");
        String customer_phone = request.getParameter("customer_phone");
        String customer_email = request.getParameter("customer_email");
        String customer_address = request.getParameter("customer_address");

        Customer customer = new Customer(customer_id, customer_type_id, customer_name, customer_birthday,customer_gender,customer_id_card,customer_phone,customer_email,customer_address);
        customerService.updateCustomer(customer);
        request.setAttribute("mess","chỉnh sửa thành công");
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/customer/edit.jsp");
        dispatcher.forward(request, response);
    }

    private void insertCustomer(HttpServletRequest request, HttpServletResponse response)
     throws SQLException, IOException, ServletException {
            int customer_id = (int)Math.random()*1000;
            int customer_type_id = Integer.parseInt(request.getParameter("customer_type_id"));
            String customer_name = request.getParameter("customer_name");
            String customer_birthday = request.getParameter("customer_birthday");
            int customer_gender = Integer.parseInt(request.getParameter("customer_gender"));
            String customer_id_card = request.getParameter("customer_id_card");
            String customer_phone = request.getParameter("customer_phone");
            String customer_email = request.getParameter("customer_email");
            String customer_address = request.getParameter("customer_address");
            Customer newCustomer = new Customer(customer_id,customer_type_id, customer_name, customer_birthday, customer_gender,customer_id_card,customer_phone,customer_email,customer_address);
             boolean check  = customerService.insertCustomer(newCustomer);
             if (check ==  true)
             {
                 request.setAttribute("mess","thêm mới thành công");
                 RequestDispatcher dispatcher = request.getRequestDispatcher("view/customer/create.jsp");
                 dispatcher.forward(request, response);
             }
             else
             {
                 request.setAttribute("mess","thêm mới thất bại");
                 RequestDispatcher dispatcher = request.getRequestDispatcher("view/customer/create.jsp");
                 dispatcher.forward(request, response);
             }

        }
    }

