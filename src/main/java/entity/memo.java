package entity;

import java.util.Date;

/**
 * @author 木易远航
 * @date 2019/11/27
 */
public class memo {
    private String MemoId;
    private String Title;
    private Date CreationTime;
    private Date ReDuration;
    private Date SetTime;
    private String Content;
    private Date LaReTime;

    public String getMemoId() {
        return MemoId;
    }

    public void setMemoId(String memoId) {
        MemoId = memoId;
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

    public Date getReDuration() {
        return ReDuration;
    }

    public void setReDuration(Date reDuration) {
        ReDuration = reDuration;
    }

    public Date getSetTime() {
        return SetTime;
    }

    public void setSetTime(Date setTime) {
        SetTime = setTime;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public Date getLaReTime() {
        return LaReTime;
    }

    public void setLaReTime(Date laReTime) {
        LaReTime = laReTime;
    }
}

