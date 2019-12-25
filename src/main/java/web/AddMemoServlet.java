package web;

import com.google.gson.Gson;
import dao.MemoDao;
import dao.UserDateDao;
import dao.impl.MemoDaoImpl;
import dao.impl.UserDateDaoImpl;
import entity.UserDate;
import entity.memo;
import entity.user;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@WebServlet(name = "AddMemoServlet",urlPatterns = "web/AddMemoServlet")
public class AddMemoServlet extends HttpServlet {
    private static final long serialVersionUID=1L;
    protected void service(HttpServletRequest request, HttpServletResponse response)throws IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        Gson gson = new Gson();
        String data=request.getParameter("addMemo");
        memo beanObjectArrayList = gson.fromJson(data, memo.class);
        MemoDao dao=new MemoDaoImpl();
        memo[] AllMemo=dao.allMemo();
        String[] LastMemoIds=(AllMemo[AllMemo.length-1].getMemoId()).split("me");
        StringBuilder LastMemoId= new StringBuilder();
        for(String lastMemoId:LastMemoIds){
            LastMemoId.append(lastMemoId);
        }
        int LastMemoid=Integer.parseInt(LastMemoId.toString());
        String newMemoId= String.valueOf(LastMemoid+1);
        if (newMemoId.length() < 6) {
            int n = 6 - newMemoId.length();
            StringBuilder m = new StringBuilder();
            for (int j = 0; j < n; j++) {
                m.append("0");
            }
            beanObjectArrayList.setMemoId( "me" + m + newMemoId);
        } else {
            beanObjectArrayList.setMemoId( "me" + newMemoId);
        }
        beanObjectArrayList.setCreationTime(new Date());
        beanObjectArrayList.setLaReTime(new Date());
        dao.addMemo(beanObjectArrayList);
        out.println("创建成功！");
        UserDateDao dao1=new UserDateDaoImpl();
        user User=(user)request.getSession().getAttribute("User");
        UserDate Dat=dao1.showUserDate(User.getUserId());
        Dat.setCreateNote(Dat.getCreateMemo()+1);
        dao1.changeUserDate(Dat);
    }
}
