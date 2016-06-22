package com.jokeher.User.Request;

import com.google.gson.Gson;
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
 * Created by 10397 on 2016/6/14.
 * <br/>
 * <pre>
 *     修改密码
 *     URL：http://localhost:8080/User/ModifyPassword?id=&password=
 *     return：{"result":true}
 * </pre>
 */
@WebServlet("/User/ModifyPassword")
public class ModifyPasswordServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer=resp.getWriter();
        int id=Integer.parseInt(req.getParameterValues("id")[0]);
        String password=req.getParameterValues("password")[0];
        if (id==0||id==1||password.equals("")){
            writer.close();
            return;
        }
        Map<String,Object> map=new HashMap<>();
        map.put("result", UserService.modifyUserPassword(id,password));
        writer.write(new Gson().toJson(map));
        writer.flush();
        writer.close();
    }
}
