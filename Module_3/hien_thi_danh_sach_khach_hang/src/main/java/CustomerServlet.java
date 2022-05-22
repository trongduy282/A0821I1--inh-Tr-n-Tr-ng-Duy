import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "customerList", urlPatterns = "/customerList")
public class CustomerServlet extends HttpServlet {
    public static List<customer> customerList = new ArrayList<>();
    @Override
    public void init() throws ServletException {
        customerList.add(new customer("Mai Văn Hoàn",  "1983-08-20", "Hà Nội",  "Hình 1"));
        customerList.add(new customer("Nguyễn Văn Nam","1983-08-21", "Bắc Giang",  "Hình 2"));
        customerList.add(new customer("Nguyễn Thái Hòa",  "1983-08-22", "Nam Định", "Hình 3"));
        customerList.add(new customer("Trần Đăng Khoa",  "1983-08-17",  "Hà Tây",  "Hình 4"));
        customerList.add(new customer("Nguyễn Đình Thi", "1983-08-19",  "Hà Nội", "Hình 5"));


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("customerList", customerList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/customerList.jsp");
        dispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
