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

@WebServlet(name = "ShowNoteServlet",urlPatterns = "web/ShowNoteServlet")
public class ShowNoteServlet extends HttpServlet {
    private static final long serialVersionUID=1L;
    protected void service(HttpServletRequest request, HttpServletResponse response)throws IOException {
        response.setContentType("text/html;charset=utf-8");
        Gson gson = new Gson();
        String data=request.getParameter("findNote");
        note beanObjectArrayList = gson.fromJson(data, note.class);
        NoteDao dao=new NoteDaoImpl();
        note[] Note=dao.allNote();
        note ChNote=new note();
        for(note note:Note){
            if(note.getNoteId().equals(beanObjectArrayList.getNoteId())){
                ChNote=note;
            }
        }
        Gson json=new Gson();
        String chNote=json.toJson(ChNote);
        response.getWriter().write(chNote);
        response.sendRedirect("Index/shownote.html");
    }
}
