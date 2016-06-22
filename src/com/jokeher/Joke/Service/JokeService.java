package com.jokeher.Joke.Service;

import com.jokeher.MySQL.SQLBase;
import com.jokeher.Joke.Model.Joke;

import java.util.List;
import java.util.Map;

/**
 * Created by 10397 on 2016/6/18.
 */
public class JokeService {

    private static final String ADD_NEW_JOKE_SQL = "INSERT INTO Joke(userId,content,isFunny,isBoring,time,publish) VALUES(%d,\'%s\',0,0,%d,%b)";
    private static final String GET_LAST_JOKE_SQL = "SELECT * FROM Joke WHERE time<%d AND publish=1 ORDER BY time ASC LIMIT 20";
    private static final String GET_HOT_JOKE_SQL="SELECT * FROM Joke ORDER BY isFunny ASC LIMIT %d,%d";


    public static boolean addNewJoke(Joke joke){
        return new SQLBase().executeSQL(String.format(ADD_NEW_JOKE_SQL,new Object[]{joke.getUserId(),joke.getContent(),joke.getTime(),joke.isPublish()}));
    }
    public static List<Map<String,Object>> getLastJokes(Long lastJokeTime){
        return new SQLBase().queryDateWithReturn(String.format(GET_LAST_JOKE_SQL,new Object[]{lastJokeTime}));
    }
    public static List<Map<String,Object>> getHotJokes(int sortToken){
        return new SQLBase().queryDateWithReturn(String.format(GET_HOT_JOKE_SQL,new Object[]{sortToken,sortToken+20}));
    }

}
