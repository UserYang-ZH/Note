package web;

import com.google.gson.Gson;
import dao.ColorDao;
import dao.impl.ColorDaoImpl;
import entity.color;
import entity.user;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoadColorServlet",urlPatterns = "web/LoadColorServlet")
public class LoadColorServlet extends HttpServlet {
    private static final long serialVersionUID=1L;
    protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        ColorDao dao=new ColorDaoImpl();
        color Color=dao.showColor(((user)request.getSession().getAttribute("User")).getUserId());
        Gson gson=new Gson();
        String color=gson.toJson(Color);
        response.getWriter().write(color);
    }
}
