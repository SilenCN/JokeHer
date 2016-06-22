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
 *     获取热门笑话，以点赞数排序，返回20条
 *     URL：http://localhost:8080/Joke/GetHotJoke?sortToken=
 *     sortToken：客户端的最分页标志，返回从该值之后的20条数据，int
 *     return：20条，Json
 *        [{"content":"cdshj","isBoring":0,"isFunny":0,"jokeId":1,"publish":true,"time":2612,"userId":1}]
 * </pre>
 */
@WebServlet("/Joke/GetHotJoke")
public class GetHotJokeServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int sortToken = Integer.parseInt(req.getParameterValues("sortToken")[0]);
            int userId=Integer.parseInt(req.getParameterValues("userId")[0]);
            resp.getWriter().write(new Gson().toJson(JokeService.getHotJokes(sortToken,userId)));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
