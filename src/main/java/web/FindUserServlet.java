package web;

import com.google.gson.Gson;
import dao.UserDao;
import dao.impl.UserDaoImpl;
import entity.user;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "FindUserServlet",urlPatterns = "web/FindUserServlet")
public class FindUserServlet extends HttpServlet {
    private static final long serialVersionUID=1L;
    protected void service(HttpServletRequest request, HttpServletResponse response)throws IOException {
        response.setContentType("text/html;charset=utf-8");
        user User=new user();
        User.setUserName(request.getParameter("userName"));
        User.setEmail(request.getParameter("email"));
        User.setPhNumber(request.getParameter("phNumber"));
        UserDao dao=new UserDaoImpl();
        user[] all=dao.findUser(User.getUserName());
        for (entity.user user : all) {
            if (user.getEmail().equals(User.getEmail())) {
                if (user.getPhNumber().equals(User.getPhNumber())) {
                    Gson gson = new Gson();
                    String right = gson.toJson("right");
                    response.getWriter().write(right);
                }
            }
        }
    }
}
