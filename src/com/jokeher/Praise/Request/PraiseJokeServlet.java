package com.jokeher.Praise.Request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * Created by 10397 on 2016/6/21.
 */
@WebServlet("/Praise/PraiseJoke")
public class PraiseJokeServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int userId=0;
        int jokeId=0;
        long time=System.currentTimeMillis();

    }
}
