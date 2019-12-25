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

@WebServlet(name = "ShowMemoServlet",urlPatterns = "web/ShowMemoServlet")
public class ShowMemoServlet extends HttpServlet {
    private static final long serialVersionUID=1L;
    protected void service(HttpServletRequest request, HttpServletResponse response)throws IOException {
        response.setContentType("text/html;charset=utf-8");
        Gson gson = new Gson();
        String data=request.getParameter("findMemo");
        memo beanObjectArrayList = gson.fromJson(data, memo.class);
        MemoDao dao=new MemoDaoImpl();
        memo[] Memo=dao.allMemo();
        memo ChMemo=new memo();
        for(memo memo:Memo){
            if(memo.getMemoId().equals(beanObjectArrayList.getMemoId())){
                ChMemo=memo;
            }
        }
        Gson json=new Gson();
        String chMemo=json.toJson(ChMemo);
        response.getWriter().write(chMemo);
        response.sendRedirect("Index/showmemo.html");
    }
}
