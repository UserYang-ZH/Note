package entity;

import java.util.Date;

/**
 * @author 木易远航
 * @date 2019/11/27
 */
public class color {
    private String UserId;
    private String BGColor;
    private String FontColor;
    private Date SetTime;
    private boolean IsRandom;

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        UserId = userId;
    }

    public String getBGColor() {
        return BGColor;
    }

    public void setBGColor(String BGColor) {
        this.BGColor = BGColor;
    }

    public String getFontColor() {
        return FontColor;
    }

    public void setFontColor(String fontColor) {
        FontColor = fontColor;
    }

    public Date getSetTime() {
        return SetTime;
    }

    public void setSetTime(Date setTime) {
        SetTime = setTime;
    }

    public boolean isRandom() {
        return IsRandom;
    }

    public void setRandom(boolean random) {
        IsRandom = random;
    }
}

