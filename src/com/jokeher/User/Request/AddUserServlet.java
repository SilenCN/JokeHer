package com.jokeher.User.Request;

import com.google.gson.Gson;
import com.jokeher.User.Model.User;
import com.jokeher.User.Service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Silen on 2016/6/14.
 * <br/>注册API
 * <br/>Url:http://localhost:8080/User/Register?username=&password=
 * <br/>return:
 * <br/>0,1,2,3:User定义
 * <br/>true，false数据库操作是否成功
 *<br/>
 *<br/>{"result":false,"status":2}
 *
 */
@WebServlet("/User/Register")
public class AddUserServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer=resp.getWriter();
        String username=req.getParameterValues("username")[0];
        String password=req.getParameterValues("password")[0];
        if (username.equals("")||password.equals("")){
            writer.close();
            return;
        }
        Map<String,Object>map=new HashMap<>();

        User user=new User(username,password);
        map.put("status",user.getStatus());
        if (user.getStatus()==User.ERROR_USERNAME_NOTEXIST){
            map.put("result",UserService.addUser(user));
        }else {
            map.put("result",false);
        }

        writer.write(new Gson().toJson(map));
        writer.flush();
        writer.close();
    }
}
