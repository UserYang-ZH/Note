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
import java.util.Arrays;

@WebServlet(name = "AllNoteServlet",urlPatterns = "web/AllNoteServlet")
public class AllNoteServlet extends HttpServlet {
    private static final long serialVersionUID=1L;
    protected void service(HttpServletRequest request, HttpServletResponse response)throws IOException {
        response.setContentType("text/html;charset=utf-8");
        NoteDao dao=new NoteDaoImpl();
        note[] Note=dao.allNote();
        Gson gson=new Gson();
        String[] all=new String[Note.length];
        for (int i=0;i<Note.length;i++) {
            all[i]= gson.toJson(Note[i]);
        }
        response.getWriter().write(Arrays.toString(all));
    }
}
