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

@WebServlet(name = "FindMemoServlet",urlPatterns = "web/FindMemoServlet")
public class FindMemoServlet extends HttpServlet {
    private static final long serialVersionUID=1L;
    protected void service(HttpServletRequest request, HttpServletResponse response)throws IOException {
        response.setContentType("text/html;charset=utf-8");
        Gson gson = new Gson();
        String data=request.getParameter("findMemo");
        memo beanObjectArrayList = gson.fromJson(data, memo.class);
        MemoDao dao=new MemoDaoImpl();
        memo[] Memo=dao.findMemoBN(beanObjectArrayList.getTitle());
        memo[] memo=new memo[Memo.length];
        for(int i=0;i<Memo.length;i++){
            memo[i].setMemoId(Memo[i].getMemoId());
            memo[i].setTitle(Memo[i].getTitle());
            memo[i].setCreationTime(Memo[i].getCreationTime());
            memo[i].setSetTime(Memo[i].getSetTime());
        }
        String[] allFind=new String[memo.length];
        for (int i=0;i<memo.length;i++) {
            allFind[i]= gson.toJson(memo[i]);
        }
        response.getWriter().write(Arrays.toString(allFind));
    }
}
