import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DiscountServlet", value = "/DiscountServlet")
public class DiscountServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String n1 = request.getParameter("ProductDescription");
        int n2 = Integer.parseInt(request.getParameter("ListPrice"));
        int n3 = Integer.parseInt(request.getParameter("DiscountPercent"));
        double n4 = n2*n3*0.01;
        //lấy biến result bên đường link jsp result.jsp, biến result tương ứng biến n4
        request.setAttribute("result",n4);
        //cặp câu lệnh chuyển từ trang java sang trang jsp hiện kết quả
        RequestDispatcher requestDisatcher = request.getRequestDispatcher("index.jsp");
        requestDisatcher.forward(request,response);

    }

}
