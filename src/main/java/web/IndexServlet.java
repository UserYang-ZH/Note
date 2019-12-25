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
import java.io.PrintWriter;

@WebServlet(name="IndexServlet",urlPatterns = "web/IndexServlet")
public class IndexServlet extends HttpServlet {
    private static final long serialVersionUID=1L;
    protected void service(HttpServletRequest request, HttpServletResponse response)throws IOException{
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        Gson gson=new Gson();
        String username=request.getParameter("Index");
        user User = gson.fromJson(username,user.class);
        UserDao Dao=new UserDaoImpl();
        user[] user=Dao.findUser(User.getUserName());
        for (entity.user u : user) {
            if (u.getPwd().equals(User.getPwd())) {
                request.getSession().setAttribute("User", User);
                response.sendRedirect("Index/home.html");
            }
        }
        out.println("账号名或密码错误！");
        response.sendRedirect("Index/index.html");
    }
}