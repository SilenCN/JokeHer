package com.jokeher.Praise.Service;

import com.jokeher.MySQL.SQLBase;
import com.jokeher.Praise.Model.PraiseReturn;

import java.util.List;
import java.util.Map;

/**
 * Created by 10397 on 2016/6/21.
 */
public class PraiseService {

    private static final String QUERY_PRAISE_EXIST_SQL = "SELECT * FROM praise_joke WHERE userId=%d and jokeId=%d";
    private static final String UPDATE_JOKE_SQL = "UPDATE joke SET isFunny=isFunny+%d,isBoring=isBoring+%d,time=%d WHERE jokeId=%d";
    private static final String UPDATE_JOKE_PRAISE_SQL = "UPDATE praise_joke SET isFunny=%b,time=%d WHERE userId=%d and jokeId=%d";
    private static final String DELETE_JOKE_PRAISE_SQL = "DELETE FROM praise_joke WHERE userId=%d and jokeId=%d";
    private static final String INSERT_JOKE_PRAISE_SQL = "INSERT INTO praise_joke(userId,jokeId,isFunny,time) VALUES(%d,%d,%b,%d)";

    public static PraiseReturn praiseJoke(int userId, int jokeId) {
        PraiseReturn praiseReturn = new PraiseReturn();
        praiseReturn.setJokeId(jokeId);
        try {
            SQLBase sqlBase = new SQLBase();
            List<Map<String, Object>> list = sqlBase.queryDateWithReturn(String.format(QUERY_PRAISE_EXIST_SQL, new Object[]{userId, jokeId}));
            if (null != list && list.size() > 0) {
                if ((boolean) list.get(0).get("isFunny")) {
                    sqlBase.executeSQL(String.format(UPDATE_JOKE_SQL, new Object[]{-1, 0, System.currentTimeMillis(), jokeId}));
                    sqlBase.executeSQL(String.format(DELETE_JOKE_PRAISE_SQL, new Object[]{userId, jokeId}));
                    praiseReturn.setFunny(false);
                    praiseReturn.setBoring(false);
                } else {
                    sqlBase.executeSQL(String.format(UPDATE_JOKE_SQL, new Object[]{1, -1, System.currentTimeMillis(), jokeId}));
                    sqlBase.executeSQL(String.format(UPDATE_JOKE_PRAISE_SQL, new Object[]{true, System.currentTimeMillis(), userId, jokeId}));
                    praiseReturn.setFunny(true);
                    praiseReturn.setBoring(false);
                }
            } else {
                sqlBase.executeSQL(String.format(UPDATE_JOKE_SQL, new Object[]{1, 0, System.currentTimeMillis(), jokeId}));
                sqlBase.executeSQL(String.format(INSERT_JOKE_PRAISE_SQL, new Object[]{userId, jokeId, true, System.currentTimeMillis()}));
                praiseReturn.setFunny(true);
                praiseReturn.setBoring(false);
            }
            praiseReturn.setSuccess(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return praiseReturn;
    }

    public static PraiseReturn antiPraiseJoke(int userId, int jokeId) {

        PraiseReturn praiseReturn = new PraiseReturn();
        praiseReturn.setJokeId(jokeId);

        try {
            SQLBase sqlBase = new SQLBase();
            List<Map<String, Object>> list = sqlBase.queryDateWithReturn(String.format(QUERY_PRAISE_EXIST_SQL, new Object[]{userId, jokeId}));
            if (null != list && list.size() > 0) {
                if (!(boolean) list.get(0).get("isFunny")) {
                    sqlBase.executeSQL(String.format(UPDATE_JOKE_SQL, new Object[]{0, -1, System.currentTimeMillis(), jokeId}));
                    sqlBase.executeSQL(String.format(DELETE_JOKE_PRAISE_SQL, new Object[]{userId, jokeId}));
                    praiseReturn.setFunny(false);
                    praiseReturn.setBoring(false);
                } else {
                    sqlBase.executeSQL(String.format(UPDATE_JOKE_SQL, new Object[]{-1, 1, System.currentTimeMillis(), jokeId}));
                    sqlBase.executeSQL(String.format(UPDATE_JOKE_PRAISE_SQL, new Object[]{false, System.currentTimeMillis(), userId, jokeId}));
                    praiseReturn.setFunny(false);
                    praiseReturn.setBoring(true);
                }
            } else {
                sqlBase.executeSQL(String.format(UPDATE_JOKE_SQL, new Object[]{0, 1, System.currentTimeMillis(), jokeId}));
                sqlBase.executeSQL(String.format(INSERT_JOKE_PRAISE_SQL, new Object[]{userId, jokeId, false, System.currentTimeMillis()}));
                praiseReturn.setFunny(false);
                praiseReturn.setBoring(true);
            }
            praiseReturn.setSuccess(true);
        } catch (Exception e) {
            e.printStackTrace();
            praiseReturn.setSuccess(false);
        }
        return praiseReturn;
    }
}

