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

@WebServlet(name = "ChangeBGCServlet",urlPatterns = "web/ChangeBGCServlet")
public class ChangeBGCServlet extends HttpServlet {
    private static final long serialVersionUID=1L;
    protected void service(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html;charset=utf-8");
        Gson gson=new Gson();
        String bg=request.getParameter("changeBGC");
        color bgc=gson.fromJson(bg, color.class);
        ColorDao dao=new ColorDaoImpl();
        user User=(user)request.getSession().getAttribute("User");
        color Color=dao.showColor(User.getUserId());
        Color.setBGColor(bgc.getBGColor());
        dao.changeColor(Color);
    }
}
