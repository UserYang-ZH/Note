package web;

import dao.ColorDao;
import dao.UserDao;
import dao.UserDateDao;
import dao.impl.ColorDaoImpl;
import dao.impl.UserDaoImpl;
import dao.impl.UserDateDaoImpl;
import entity.UserDate;
import entity.color;
import entity.user;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@WebServlet(name="RegistServlet",urlPatterns = "web/RegistServlet")
public class RegistServlet extends HttpServlet {
    private static final long serialVersionUID=1L;
    protected void service(HttpServletRequest request, HttpServletResponse response)throws IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        user User=new user();
        User.setUserName(request.getParameter("name"));
        User.setPhNumber(request.getParameter("phone-number"));
        User.setEmail(request.getParameter("email"));
        User.setPwd(request.getParameter("password"));
        if(User.getUserName().length()==0||User.getPhNumber().length()==0||User.getEmail().length()==0||User.getPwd().length()==0){
            out.println("信息不完整！");
            response.sendRedirect("Index/registered.html");
        }
        UserDao dao=new UserDaoImpl();
        user[] users=dao.allUser();
        UserDateDao dao1=new UserDateDaoImpl();
        ColorDao dao2=new ColorDaoImpl();
        String[] LastUserIds=(users[users.length-1].getUserId()).split("yh");
        StringBuilder LastUserId= new StringBuilder();
        for (String lastUserId : LastUserIds) {
            LastUserId.append(lastUserId);
        }
        Object newUserIdM=Integer.parseInt(LastUserId.toString())+1;
        String newUserId= (String) newUserIdM;
        String UserId;
        if(newUserId.length()<6){
            int a=6-newUserId.length();
            StringBuilder b= new StringBuilder();
            for(int i=0;i<a;i++){
                b.append("0");
            }
            UserId="yh"+b+newUserId;
        }
        else{
            UserId="yh"+newUserId;
        }
        User.setUserId(UserId);
        UserDate UserDate=new UserDate();
        UserDate.setUserId(UserId);
        UserDate.setRegistTime(new Date());
        dao.addUser(User);
        dao1.addUserDate(UserDate);
        user[] user=dao.findUser(User.getUserName());
        UserDate userDates=dao1.showUserDate(User.getUserId());
        color Color=new color();
        Color.setUserId(User.getUserId());
        Color.setBGColor("white");
        Color.setFontColor("black");
        Color.setSetTime(new Date());
        Color.setRandom(false);
        dao2.addColor(Color);
        for (entity.user value : user) {
            if (User.getUserId().equals(value.getUserId())) {
                if (userDates != null) {
                    request.getSession().setAttribute("UserId", value.getUserId());
                    out.println("注册成功！");
                    response.sendRedirect("Index/index.html");
                }
            }
        }
        out.println("注册结束");
        response.sendRedirect("Index/registered.html");
    }
}
