package com.jokeher.Update.Request;

import com.google.gson.Gson;
import com.jokeher.Update.Service.VersionService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Silen on 2016/6/15.
 * <br/>
 * <pre>
 *     检查更新
 *     URL：http://localhost:8080/Update/CheckUpdate?version=
 *     version：float
 *     return:json List<Map<String,Object>>
 *         [{"forceUpdate":true,"token":1,"updateInfo":"cscsxs","updateTime":21231351562626,"url":"csdcd","version":1.0},{"forceUpdate":true,"token":2,"updateInfo":"cscsxs","updateTime":21231351562626,"url":"csdcd","version":2.1}]
 *
 *         if not,[]
 * </pre>
 */
@WebServlet("/Update/CheckUpdate")
public class CheckUpdateServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        float version=Float.parseFloat(req.getParameterValues("version")[0]);
        resp.getWriter().write(new Gson().toJson(VersionService.getAllUpdateVersion(version)));
    }
}
