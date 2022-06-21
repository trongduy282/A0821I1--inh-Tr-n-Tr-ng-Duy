package controller;

import model.bean.Customer;
import model.bean.Employee;
import model.service.ICustomerService;
import model.service.IEducationService;
import model.service.IEmployeeService;
import model.service.IPositionService;
import model.service.impl.CustomerService;
import model.service.impl.EducationService;
import model.service.impl.EmployeeService;
import model.service.impl.PositionService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "EmployeeServlet", value = "/employee")
public class EmployeeServlet extends HttpServlet {
    IEmployeeService employeeService = new EmployeeService();
    IEducationService educationService = new EducationService();
    IPositionService positionService = new PositionService();
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
                    deleteEmployee(request, response);
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
                showListEmployee(request,response);


        }
    }

    private void search(HttpServletRequest request, HttpServletResponse response) {
        String nameSearch = request.getParameter("nameSearch");
        String cardSearch = request.getParameter("cardSearch");
        String addressSearch = request.getParameter("addressSearch");
        List<Employee> employeeList = employeeService.search(nameSearch,cardSearch,addressSearch);
        request.setAttribute("employeeList", employeeList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/employee/list.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteEmployee(HttpServletRequest request, HttpServletResponse response)  throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        employeeService.deleteEmployee(id);

        List<Employee> employeeList = employeeService.getAllEmployee();
        request.setAttribute("employeeList", employeeList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/employee/list.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Employee existingEmployee = employeeService.selectEmployee(id);
        request.setAttribute("employee",existingEmployee);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/employee/edit.jsp");
        request.setAttribute("employee", existingEmployee);
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {

        request.setAttribute("educationList",educationService.getAllEducation());
        request.setAttribute("positionList",positionService.getAllPosition());
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/employee/create.jsp");
        dispatcher.forward(request, response);
    }

    private void showListEmployee(HttpServletRequest request, HttpServletResponse response) {
        List<Employee> employeeList = employeeService.getAllEmployee();
        request.setAttribute("employeeList", employeeList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/employee/list.jsp");
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
        if (action==null){
            action ="";
        }
        switch (action){
            case "create":
//                try {
                try {
                    insertEmployee(request, response);
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
                try {
                    updateEmployee(request, response);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
//
                // chinh sua
                break;
            case "delete":
                // xóa
            default:


        }
    }

    private void updateEmployee(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
            int employee_id = Integer.parseInt(request.getParameter("employee_id"));
            String employee_name = request.getParameter("employee_name");
            String employee_birthday = request.getParameter("employee_birthday");
            String employee_id_card = request.getParameter("employee_id_card");
            String employee_salary = request.getParameter("employee_salary");
            String employee_phone = request.getParameter("employee_phone");
            String employee_email = request.getParameter("employee_email");
            String employee_address = request.getParameter("employee_address");
            int position_id = Integer.parseInt(request.getParameter("position_id"));
            int education_degree_id = Integer.parseInt(request.getParameter("education_degree_id"));
            int division_id = Integer.parseInt(request.getParameter("division_id"));
            Employee newEmployee = new Employee(employee_id, employee_name, employee_birthday, employee_id_card,employee_salary,employee_phone,employee_email,employee_address,position_id,education_degree_id,division_id);
            employeeService.updateEmployee(newEmployee);
            request.setAttribute("mess","chỉnh sửa thành công");
            RequestDispatcher dispatcher = request.getRequestDispatcher("view/employee/edit.jsp");
            dispatcher.forward(request, response);
    }

    private void insertEmployee(HttpServletRequest request, HttpServletResponse response)
         throws SQLException, IOException, ServletException {
            int employee_id = (int)Math.random()*1000;
            String employee_name = request.getParameter("employee_name");
            String employee_birthday = request.getParameter("employee_birthday");
            String employee_id_card = request.getParameter("employee_id_card");
            String employee_salary = request.getParameter("employee_salary");
            String employee_phone = request.getParameter("employee_phone");
            String employee_email = request.getParameter("employee_email");
            String employee_address = request.getParameter("employee_address");
            int position_id = Integer.parseInt(request.getParameter("position_id"));
            int education_degree_id = Integer.parseInt(request.getParameter("education_degree_id"));
            int division_id = Integer.parseInt(request.getParameter("division_id"));
            Employee newEmployee = new Employee(employee_id, employee_name, employee_birthday, employee_id_card,employee_salary,employee_phone,employee_email,employee_address,position_id,education_degree_id,division_id);
            boolean check  = employeeService.insertEmployee(newEmployee);
            if (check)
            {
                request.setAttribute("mess","thêm mới thành công");
                RequestDispatcher dispatcher = request.getRequestDispatcher("view/employee/create.jsp");
                dispatcher.forward(request, response);
            }
            else
            {
                request.setAttribute("mess","thêm mới thất bại");
                RequestDispatcher dispatcher = request.getRequestDispatcher("view/employee/create.jsp");
                dispatcher.forward(request, response);
            }

        }
}
