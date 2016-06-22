package com.jokeher.Joke.Request;

import com.jokeher.Joke.Model.Joke;
import com.jokeher.Joke.Service.JokeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by 10397 on 2016/6/18.
 * <pre>
 *     添加笑话
 *     URL：http://localhost:8080/Joke/AddNewJoke?userId=&content=&publish=
 *     userId:user的id,int
 *     content:笑话内容，string
 *     publish：是否发布给其他人，boolean
 *
 *     return：
 *      true：成功
 *      false or null：失败
 * </pre>
 */
@WebServlet("/Joke/AddNewJoke")
public class AddNewJokeServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Joke joke=new Joke();
            joke.setUserId(Integer.parseInt( req.getParameterValues("userId")[0]));
            joke.setContent(req.getParameterValues("content")[0]);
            joke.setPublish(Boolean.parseBoolean(req.getParameterValues("publish")[0]));
            joke.setTime(System.currentTimeMillis());
            resp.getWriter().write(JokeService.addNewJoke(joke)+"");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
