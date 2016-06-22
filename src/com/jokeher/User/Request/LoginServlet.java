package com.jokeher.User.Request;

import com.google.gson.Gson;
import com.jokeher.User.Model.User;

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
 * Created by 10397 on 2016/6/14.
 * <br/>
 * <pre>
 *     登陆
 *     URL：http://localhost:8080/User/Login?username=&password=
 *     return：{"result":true,"id":1,"status":0}
 * </pre>
 */
@WebServlet("/User/Login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        String username = req.getParameterValues("username")[0];
        String password = req.getParameterValues("password")[0];
        if (username.equals("") || password.equals("")) {
            writer.close();
            return;
        }
        Map<String, Object> map = new HashMap<>();

        User user = new User(username, password);
        map.put("status", user.getStatus());
        if (user.getStatus() == User.USER_RIGHT) {
            map.put("id", user.getId());
            map.put("result", true);
        } else {
            map.put("result", false);
            map.put("id", -1);
        }

        writer.write(new Gson().toJson(map));
        writer.flush();
        writer.close();
    }
}
