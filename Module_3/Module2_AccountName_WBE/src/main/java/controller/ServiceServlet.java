package controller;

import model.bean.Employee;
import model.bean.Service;
import model.service.IEmployeeService;
import model.service.IServiceService;
import model.service.impl.EmployeeService;
import model.service.impl.ServiceService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "ServiceServlet", urlPatterns = "/service")
public class ServiceServlet extends HttpServlet {
    IServiceService serviceServiceService = new ServiceService();
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
//                try {
////                    showEditForm(request, response);
//                } catch (SQLException throwables) {
//                    throwables.printStackTrace();
//                }
                // chỉnh sửa
                break;
            case "delete":
//                try {
//                    deleteEmployee(request, response);
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
                showNewForm(request, response);


        }
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/service/create.jsp");
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
//                try {
                try {
                    insertService(request, response);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
//                } catch (SQLException throwables) {
//                    throwables.printStackTrace();
//                }
                // lưu dữ liệu
//                save(request,response);
                break;
            case "edit":
//
//                try {
//                    updateEmployee(request, response);
//                } catch (SQLException throwables) {
//                    throwables.printStackTrace();
//                }
////
                // chinh sua
                break;
            case "delete":
                // xóa
            default:
                try {
                    insertService(request, response);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
        }
    }

    private void insertService(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        int service_id = (int)Math.random()*1000;
        String service_name = request.getParameter("service_name");
        int service_area = Integer.parseInt(request.getParameter("service_area"));
        double service_cost = Double.parseDouble(request.getParameter("service_cost"));
        int service_max_people = Integer.parseInt(request.getParameter("service_max_people"));
        int rent_type_id = Integer.parseInt(request.getParameter("rent_type_id"));
        int service_type_id = Integer.parseInt(request.getParameter("service_type_id"));
        String standard_room = request.getParameter("standard_room");
        String description_other_convenience = request.getParameter("description_other_convenience");
        double pool_area = Double.parseDouble(request.getParameter("pool_area"));
        int number_of_floors = Integer.parseInt(request.getParameter("number_of_floors"));
        Service newService = new Service(service_id, service_name, service_area, service_cost,service_max_people,rent_type_id,service_type_id,standard_room,description_other_convenience,pool_area,number_of_floors);
        boolean check  = serviceServiceService.insertService(newService);
        if (check)
        {
            request.setAttribute("mess","thêm mới thành công");
            RequestDispatcher dispatcher = request.getRequestDispatcher("view/service/create.jsp");
            dispatcher.forward(request, response);
        }
        else
        {
            request.setAttribute("mess","thêm mới thất bại");
            RequestDispatcher dispatcher = request.getRequestDispatcher("view/service/create.jsp");
            dispatcher.forward(request, response);
        }
    }
}
