package com.jokeher;

/**
 * Created by 10397 on 2016/6/15.
 */
public class init {
    private static final String CREATE_VERSION_TABLE_SQL  = "CREATE TABLE version(token INTEGER PRIMARY KEY AUTO_INCREMENT,version INTEGER NOT NULL,forceUpdate BOOLEAN,updateInfo TEXT NOT NULL,url TEXT,updateTime BIGINT)";
    private static final String CREATE_USER_TABLE_SQL = "CREATE TABLE user(id INTEGER PRIMARY KEY AUTO_INCREMENT,username TEXT NOT NULL,password TEXT NOT NULL)";
    private static final String CREATE_JOKE_TABLE_SQL="CREATE TABLE joke(jokeId INTEGER PRIMARY KEY AUTO_INCREMENT,userId INTEGER NOT NULL,content TEXT NOT NULL,isFunny INTEGER,isBoring INTEGER,time BIGINT NOT NULL,publish BOOLEAN)";
    private static final String CREATE_PRAISE_JOKE_TABLE_SQL="CREATE TABLE praise_joke(token INTEGER PRIMARY KEY AUTO_INCREMENT,userId INTEGER NOT NULL,jokeId INTEGER NOT NULL,isFunny BOOLEAN NOT NULL,time BIGINT)";
}
