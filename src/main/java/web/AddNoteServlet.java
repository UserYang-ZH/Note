package web;

import com.google.gson.Gson;
import dao.NoteDao;
import dao.UserDateDao;
import dao.impl.NoteDaoImpl;
import dao.impl.UserDateDaoImpl;
import entity.UserDate;
import entity.note;
import entity.user;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@WebServlet(name = "AddNoteServlet",urlPatterns = "web/AddNoteServlet")
public class AddNoteServlet extends HttpServlet {
    private static final long serialVersionUID=1L;
    protected void service(HttpServletRequest request, HttpServletResponse response)throws IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        Gson gson = new Gson();
        String data=request.getParameter("addnote");
        note beanObjectArrayList = gson.fromJson(data, note.class);
        NoteDao dao=new NoteDaoImpl();
        UserDateDao dao1=new UserDateDaoImpl();
        note[] AllNote=dao.allNote();
        String[] LastNoteIds=(AllNote[AllNote.length-1].getNoteId()).split("no");
        StringBuilder LastNoteId= new StringBuilder();
        for(String lastNoteId:LastNoteIds){
            LastNoteId.append(lastNoteId);
        }
        int LastNoteid=Integer.parseInt(LastNoteId.toString());
        String newNoteId= String.valueOf(LastNoteid+1);
        if (newNoteId.length() < 6) {
            int n = 6 - newNoteId.length();
            StringBuilder m = new StringBuilder();
            for (int j = 0; j < n; j++) {
                m.append("0");
            }
            beanObjectArrayList.setNoteId("no" + m + newNoteId);
        } else {
            beanObjectArrayList.setNoteId("no" + newNoteId);
        }
        beanObjectArrayList.setCreationTime(new Date());
        beanObjectArrayList.setLaReTime(new Date());
        dao.addNote(beanObjectArrayList);
        out.println("创建成功！");
        user User=(user)request.getSession().getAttribute("User");
        UserDate date=dao1.showUserDate(User.getUserId());
        date.setCreateNote(date.getCreateNote()+1);
        dao1.changeUserDate(date);
    }
}
