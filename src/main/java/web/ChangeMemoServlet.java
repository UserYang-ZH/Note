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
import java.util.Date;

@WebServlet(name = "ChangeMemoServlet",urlPatterns = "web/ChangeMemoServlet")
public class ChangeMemoServlet extends HttpServlet {
    private static final long serialVersionUID=1L;
    protected void service(HttpServletRequest request, HttpServletResponse response)throws IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        Gson gson=new Gson();
        String data=request.getParameter("changeMemo");
        memo beanObjectArrayList = gson.fromJson(data, memo.class);
        MemoDao dao=new MemoDaoImpl();
        memo Memo=dao.findMemoBI(beanObjectArrayList.getMemoId());
        Memo.setTitle(beanObjectArrayList.getTitle());
        Memo.setContent(beanObjectArrayList.getContent());
        Memo.setSetTime(beanObjectArrayList.getSetTime());
        Memo.setReDuration(beanObjectArrayList.getReDuration());
        Memo.setCreationTime(Memo.getCreationTime());
        Memo.setLaReTime(new Date());
        dao.changeMemo(Memo);
        out.println("修改成功！");
    }
}
