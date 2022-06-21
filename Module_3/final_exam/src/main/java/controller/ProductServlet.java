package controller;

import model.bean.Product;
import model.service.IProductService;
import model.service.impl.ProductService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ProductServlet", urlPatterns = "/product")
public class ProductServlet extends HttpServlet {
    IProductService productService = new ProductService();
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
//                try {
                try {
                    deleteProduct(request, response);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
//                } catch (SQLException throwables) {
//                    throwables.printStackTrace();
//                }
                break;
            case "search":
                search(request,response);
                break;
            // xóa
            default:
                // trả về trang list
                showListProduct(request,response);


        }
    }

    private void search(HttpServletRequest request, HttpServletResponse response) {
        String nameSearch = request.getParameter("nameSearch");
        List<Product> productList = productService.search(nameSearch);
        request.setAttribute("productList", productList);
//        request.setAttribute("classList", classCGList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/product/list.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response)
  throws SQLException, IOException, ServletException {
            int id = Integer.parseInt(request.getParameter("id"));
            productService.deleteProduct(id);

            List<Product> productList = productService.getAllProduct();
            request.setAttribute("productList", productList);
            RequestDispatcher dispatcher = request.getRequestDispatcher("view/product/list.jsp");
            dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
             throws SQLException, ServletException, IOException {
            int id = Integer.parseInt(request.getParameter("id"));
            Product existingProduct = productService.selectProduct(id);
            request.setAttribute("product",existingProduct);
            RequestDispatcher dispatcher = request.getRequestDispatcher("view/product/edit.jsp");
            request.setAttribute("product", existingProduct);
            dispatcher.forward(request, response);
    }


    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/product/create.jsp");
        dispatcher.forward(request, response);
    }


    private void showListProduct(HttpServletRequest request, HttpServletResponse response) {
        List<Product> productList = productService.getAllProduct();
        request.setAttribute("productList", productList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/product/list.jsp");
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
                try {
                    insertProduct(request, response);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                // lưu dữ liệu
//                save(request,response);
                break;
            case "edit":
//                try {
                try {
                    updateProduct(request, response);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
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

    private void updateProduct(HttpServletRequest request, HttpServletResponse response)
 throws SQLException, IOException, ServletException {
            int product_id = Integer.parseInt(request.getParameter("product_id"));
            String product_name = request.getParameter("product_name");
            int price = Integer.parseInt(request.getParameter("price"));
            int quantity = Integer.parseInt(request.getParameter("quantity"));
            String color = request.getParameter("color");
            String des = request.getParameter("des");
            int category_id = Integer.parseInt(request.getParameter("category_id"));

            Product product = new Product(product_id, product_name, price, quantity,color,des,category_id);
            productService.updateProduct(product);
            request.setAttribute("mess","chỉnh sửa thành công");
            RequestDispatcher dispatcher = request.getRequestDispatcher("view/product/edit.jsp");
            dispatcher.forward(request, response);
    }

    private void insertProduct(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
            int product_id = (int)Math.random()*1000;
            String product_name = request.getParameter("product_name");
            int price = Integer.parseInt(request.getParameter("price"));
            int quantity = Integer.parseInt(request.getParameter("quantity"));
            String color = request.getParameter("color");
//            int customer_gender = Integer.parseInt(request.getParameter("customer_gender"));
            String des = request.getParameter("des");
            int category_id = Integer.parseInt(request.getParameter("category_id"));
            Product newProduct = new Product(product_id,product_name, price, quantity, color,des,category_id);
            boolean check  = productService.insertProduct(newProduct);
            if (check ==  true)
            {
                request.setAttribute("mess","thêm mới thành công");
                RequestDispatcher dispatcher = request.getRequestDispatcher("view/product/create.jsp");
                dispatcher.forward(request, response);
            }
            else
            {
                request.setAttribute("mess","thêm mới thất bại");
                RequestDispatcher dispatcher = request.getRequestDispatcher("view/product/create.jsp");
                dispatcher.forward(request, response);
            }

    }
}
