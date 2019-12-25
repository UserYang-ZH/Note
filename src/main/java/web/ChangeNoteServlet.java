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
import java.util.Date;

@WebServlet(name = "ChangeNoteServlet",urlPatterns = "web/ChangeNoteServlet")
public class ChangeNoteServlet extends HttpServlet {
    private static final long serialVersionUID=1L;
    protected void service(HttpServletRequest request, HttpServletResponse response)throws IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        Gson gson = new Gson();
        String data=request.getParameter("ChangeNote");
        note beanObjectArrayList = gson.fromJson(data, note.class);
        NoteDao dao=new NoteDaoImpl();
        note Note=dao.findNoteBI(beanObjectArrayList.getNoteId());
        Note.setTitle(beanObjectArrayList.getTitle());
        Note.setContent(beanObjectArrayList.getContent());
        Note.setWordCount(beanObjectArrayList.getContent().length());
        Note.setLaReTime(new Date());
        Note.setCreationTime(Note.getCreationTime());
        dao.changeNote(Note);
        out.println("修改成功！");
    }
}
