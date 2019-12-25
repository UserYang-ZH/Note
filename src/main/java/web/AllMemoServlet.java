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
import java.util.Arrays;

@WebServlet(name = "AllMemoServlet",urlPatterns = "web/AllMemoServlet")
public class AllMemoServlet extends HttpServlet {
    private static final long serialVersionUID=1L;
    protected void service(HttpServletRequest request, HttpServletResponse response)throws IOException {
        response.setContentType("text/html;charset=utf-8");
        MemoDao dao=new MemoDaoImpl();
        memo[] Memo=dao.allMemo();
        Gson gson=new Gson();
        String[] all=new String[Memo.length];
        for (int i=0;i<Memo.length;i++) {
            all[i]= gson.toJson(Memo[i]);
        }
        response.getWriter().write(Arrays.toString(all));
    }
}
