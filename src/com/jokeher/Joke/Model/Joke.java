package com.jokeher.Joke.Model;

/**
 * Created by 10397 on 2016/6/18.
 */
public class Joke {
    private int userId;
    private String content;
    private int jokeId;
    private int isFunny=0;
    private int isBoring=0;
    private long time=0;
    private boolean publish=true;

    public boolean isPublish() {
        return publish;
    }

    public void setPublish(boolean publish) {
        this.publish = publish;
    }

    public int getIsBoring() {
        return isBoring;
    }

    public void setIsBoring(int isBoring) {
        this.isBoring = isBoring;
    }

    public int getIsFunny() {
        return isFunny;
    }

    public void setIsFunny(int isFunny) {
        this.isFunny = isFunny;
    }

    public int getJokeId() {
        return jokeId;
    }

    public void setJokeId(int jokeId) {
        this.jokeId = jokeId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
