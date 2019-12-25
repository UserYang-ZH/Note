package web;

import com.google.gson.Gson;
import dao.NoteDao;
import dao.impl.NoteDaoImpl;
import entity.note;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Type;

@WebServlet(name = "DeleNoteServlet",urlPatterns = "web/DeleNoteServlet")
public class DeleNoteServlet extends HttpServlet {
    private static final long serialVersionUID=1L;
    protected void service(HttpServletRequest request, HttpServletResponse response)throws IOException{
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        Gson gson = new Gson();
        NoteDao dao=new NoteDaoImpl();
        String data=request.getParameter("DeleteNote");
        String data0=request.getParameter("DeleNote");
        if(data!=null) {
            note beanObjectArrayList = gson.fromJson(data, note.class);
            dao.deleNote(beanObjectArrayList.getNoteId());
        }
        else if(data0!=null){
            note[] beanObjectArrayList = gson.fromJson(data0, (Type) note.class);
            note[] Note=new note[beanObjectArrayList.length];
            for(int i=0;i<beanObjectArrayList.length;i++) {
                note[] Note1=dao.findNoteBN(beanObjectArrayList[i].getTitle());
                Note[i]=Note1[Note1.length-1];
            }
            for(entity.note note:Note){
                dao.deleNote(note.getNoteId());
            }
        }
        else{
            out.println("请求出错！");
        }
    }
}
