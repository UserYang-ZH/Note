package web;

import com.google.gson.Gson;
import dao.MemoDao;
import dao.impl.MemoDaoImpl;
import entity.memo;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Date;

@WebServlet(name = "HomeServlet",urlPatterns = "web/HomeServlet")
public class HomeServlet extends HttpServlet {
    private static final long serialVersionUID=1L;
    protected void service(HttpServletRequest request, HttpServletResponse response)throws IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out=response.getWriter();
        MemoDao dao=new MemoDaoImpl();
        memo[] Memo=dao.allMemo();
        Date date=new Date();
        for (entity.memo value : Memo) {
            long time = value.getSetTime().getTime() - value.getReDuration().getTime();
            if (date.getTime() > value.getSetTime().getTime()) {
                dao.deleMemo(value.getMemoId());
            } else if (date.getTime() > time && date.getTime() < value.getSetTime().getTime()) {
                out.flush();
                out.println("<script>");
                out.println("alert('备忘录" + value.getTitle() + "正在提醒中！');");
                out.println("</script>");
            }
        }
        memo[] Memo1=dao.allMemo();
        memo[] memo=new memo[5];
        System.arraycopy(Memo1, 0, memo, 0, 5);
        Gson gson=new Gson();
        String[] all=new String[5];
        for (int i=0;i<5;i++) {
            all[i]= gson.toJson(memo[i]);
        }
        response.getWriter().write(Arrays.toString(all));
    }
}
