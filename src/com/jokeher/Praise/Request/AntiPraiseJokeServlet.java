package com.jokeher.Praise.Request;

import com.google.gson.Gson;
import com.jokeher.Praise.Service.PraiseService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by 10397 on 2016/6/22.
 * 踩API
 * <pre>
 *     URL:http://localhost:8080/Praise/PraiseJoke?userId=&jokeId=
 *     userId:user的id,int
 *     jokeId:joke的id,int
 *     当踩存在时，删除记录
 *     当为赞时，踩，删除赞
 *     当踩不存在时，新增
 *     return:JSON
 *     {"success":true,"funny":false,"boring":true,"jokeId":1}
 *     操作结果，success代表是否有错误，funny：赞，boring：踩，jokeId：joke的id
 * </pre>
 */
@WebServlet("/Praise/AntiPraiseJoke")
public class AntiPraiseJokeServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int userId = Integer.parseInt(req.getParameterValues("userId")[0]);
            int jokeId = Integer.parseInt(req.getParameterValues("jokeId")[0]);
            resp.getWriter().write(new Gson().toJson(PraiseService.antiPraiseJoke(userId, jokeId)));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
