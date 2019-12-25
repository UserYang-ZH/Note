package entity;

import java.sql.Time;
import java.util.Date;

/**
 * @author 木易远航
 * @date 2019/11/27
 */
public class UserDate {
    private String UserId;
    private Date RegistTime;
    private int CreateNote;
    private int CreateMemo;
    private Time Duration;

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        UserId = userId;
    }

    public Date getRegistTime() {
        return RegistTime;
    }

    public void setRegistTime(Date registTime) {
        RegistTime = registTime;
    }

    public int getCreateNote() {
        return CreateNote;
    }

    public void setCreateNote(int createNote) {
        CreateNote = createNote;
    }

    public int getCreateMemo() {
        return CreateMemo;
    }

    public void setCreateMemo(int createMemo) {
        CreateMemo = createMemo;
    }

    public Time getDuration() {
        return Duration;
    }

    public void setDuration(Time duration) {
        Duration = duration;
    }
}

