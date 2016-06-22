package com.jokeher.User.Service;

import com.jokeher.MySQL.SQLBase;
import com.jokeher.User.Model.User;


/**
 * Created by 10397 on 2016/6/14.
 */
public class UserService {

    private static final String ADD_USER_SQL = "INSERT INTO user(username,password) VALUES(\'%s\',\'%s\')";
    private static final String MODIFY_USER_PASSWORD_SQL = "UPDATE user SET password=\'%s\' WHERE id=%d";

    public static boolean addUser(User user){
        return new SQLBase().executeSQL(String.format(ADD_USER_SQL,new Object[]{user.getUsername(),user.getPassword()}));
    }
    public static boolean modifyUserPassword(int id,String newPassword){
        return new SQLBase().executeSQL(String.format(MODIFY_USER_PASSWORD_SQL,new Object[]{newPassword,id}));
    }
}
