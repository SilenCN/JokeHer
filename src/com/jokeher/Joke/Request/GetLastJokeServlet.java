package com.jokeher.Joke.Request;

import com.google.gson.Gson;
import com.jokeher.Joke.Service.JokeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by 10397 on 2016/6/19.
 * <pre>
 *     获取最新笑话，返回20条JSON
 *     URL:http://localhost:8080/Joke/GetLastJoke?time=
 *     time:客户端得到的最旧的时间，long
 *     return：JOSN
 *     [{"content":"cdshj","isBoring":0,"isFunny":0,"jokeId":1,"publish":true,"time":2612,"userId":1}]
 * </pre>
 */
@WebServlet("/Joke/GetLastJoke")
public class GetLastJokeServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            long lastJokeTime = Long.parseLong(req.getParameterValues("time")[0]);
            resp.getWriter().write(new Gson().toJson(JokeService.getLastJokes(lastJokeTime)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

