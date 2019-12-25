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

@WebServlet(name = "FindNoteServlet",urlPatterns = "web/FindNoteServlet")
public class FindNoteServlet extends HttpServlet {
    private static final long serialVersionUID=1L;
    protected void service(HttpServletRequest request, HttpServletResponse response)throws IOException {
        response.setContentType("text/html;charset=utf-8");
        Gson gson = new Gson();
        String data=request.getParameter("findNote");
        note beanObjectArrayList = gson.fromJson(data, note.class);
        NoteDao dao=new NoteDaoImpl();
        note[] Note=dao.findNoteBN(beanObjectArrayList.getTitle());
        note[] note=new note[Note.length];
        for(int i=0;i<Note.length;i++){
            note[i].setNoteId(Note[i].getNoteId());
            note[i].setTitle(Note[i].getTitle());
            note[i].setCreationTime(Note[i].getCreationTime());
            note[i].setLaReTime(Note[i].getLaReTime());
        }
        String[] allFind=new String[note.length];
        for (int i=0;i<note.length;i++) {
            allFind[i]= gson.toJson(note[i]);
        }
        response.getWriter().write(Arrays.toString(allFind));
    }
}
