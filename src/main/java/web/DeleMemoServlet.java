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
import java.lang.reflect.Type;

@WebServlet(name = "DeleMemoServlet",urlPatterns = "web/DeleMemoServlet")
public class DeleMemoServlet extends HttpServlet {
    private static final long serialVersionUID=1L;
    protected void service(HttpServletRequest request, HttpServletResponse response)throws IOException{
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        Gson gson = new Gson();
        MemoDao dao=new MemoDaoImpl();
        String data=request.getParameter("DeleteMemo");
        String data0=request.getParameter("DeleMemo");
        if(data!=null) {
            memo beanObjectArrayList =gson.fromJson(data, memo.class);
            dao.deleMemo(beanObjectArrayList.getMemoId());
        }
        else if(data0!=null){
            memo[] beanObjectArrayList = gson.fromJson(data0, (Type) memo.class);
            memo[] memo=new memo[beanObjectArrayList.length];
            for(int i=0;i<beanObjectArrayList.length;i++) {
                memo[] Memo=dao.findMemoBN(beanObjectArrayList[i].getTitle());
                memo[i]=Memo[Memo.length-1];
            }
            for(entity.memo me:memo){
                dao.deleMemo(me.getMemoId());
            }
        }
        else{
            out.println("请求出错！");
        }
    }
}
