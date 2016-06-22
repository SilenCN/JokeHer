package com.jokeher.Praise.Service;

import com.jokeher.MySQL.SQLBase;

import java.util.List;
import java.util.Map;

/**
 * Created by 10397 on 2016/6/21.
 */
public class PraiseService {
    private static final String QUARY_PARISE_EXIST_SQL = "SELECT * FROM praise_joke WHERE userId=%d and jokeId=%d";

    public static void praiseJoke(int userId,int jokeId){
        SQLBase sqlBase=new SQLBase();
        List<Map<String,Object>> list=sqlBase.queryDateWithReturn(String.format(QUARY_PARISE_EXIST_SQL,new Object[]{userId,jokeId}));


    }
}
