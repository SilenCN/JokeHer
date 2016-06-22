package com.jokeher.User.Model;

import com.jokeher.MySQL.SQLBase;

import java.util.List;
import java.util.Map;

/**
 * Created by 10397 on 2016/6/13.
 */
public class User {
    public static final int ERROR_USERNAME_NOTEXIST = 1;
    public static final int ERROR_PASSWORD_WRONG = 2;
    public static final int USER_RIGHT = 0;
    private String username;
    private String password;
    private int id=-1;
    private int status;

    public User(String username,String password){
        this.username=username;
        this.password=password;
        init();
    }

    private void init(){
        SQLBase sql=new SQLBase();
        List<Map<String,Object>> result=sql.queryDateWithReturn("SELECT * FROM user WHERE username=\'"+username+"\'");
        if (result.isEmpty()){
            status=ERROR_USERNAME_NOTEXIST;
        }else if (this.password.equals(result.get(0).get("password").toString())){
            status=USER_RIGHT;
            this.id=(int)result.get(0).get("id");
        }else {
            status=ERROR_PASSWORD_WRONG;
        }
    }

    public int getId(){
        return id;
    }

    public String getUsername(){
        return this.username;
    }


    public String getPassword(){
        return this.password;
    }
    public int getStatus(){
        return this.status;
    }
}
