package entity;

import java.util.Date;

/**
 * @author 木易远航
 * @date 2019/11/27
 */
public class note {
    private String NoteId;
    private String Title;
    private Date CreationTime;
    private String Content;
    private int WordCount;
    private Date LaReTime;

    public String getNoteId() {
        return NoteId;
    }

    public void setNoteId(String noteId) {
        NoteId = noteId;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public Date getCreationTime() {
        return CreationTime;
    }

    public void setCreationTime(Date creationTime) {
        CreationTime = creationTime;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public int getWordCount() {
        return WordCount;
    }

    public void setWordCount(int wordCount) {
        WordCount = wordCount;
    }

    public Date getLaReTime() {
        return LaReTime;
    }

    public void setLaReTime(Date laReTime) {
        LaReTime = laReTime;
    }
}

