package com.jokeher.Praise.Model;

/**
 * Created by 10397 on 2016/6/21.
 */
public class PraiseReturn {
    private boolean success = false;
    private boolean funny = true;
    private boolean boring = false;
    private int jokeId = 0;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public boolean isFunny() {
        return funny;
    }

    public void setFunny(boolean funny) {
        this.funny = funny;
    }

    public boolean isBoring() {
        return boring;
    }

    public void setBoring(boolean boring) {
        this.boring = boring;
    }

    public int getJokeId() {
        return jokeId;
    }

    public void setJokeId(int jokeId) {
        this.jokeId = jokeId;
    }
}
