package com.jokeher.Update.Request;

import com.jokeher.Update.Model.Version;
import com.jokeher.Update.Service.VersionService;
import com.jokeher.User.Model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by 10397 on 2016/6/14.
 * <br/>
 * <pre>
 *     提交新版本API
 *     URL：http://localhost:8080/Update/NewVersion?version=&forceUpdate=&updateInfo=&username=&password=&updateTime=&url=
 *     Version：float
 *     forceUpdate：boolean
 *     updateInfo：String
 *     updateTime:Long
 *     username，password：ADMIN USER
 *     url:String
 *     return：true:update or insert success
 *             false:failure
 * </pre>
 */
@WebServlet("/Update/NewVersion")
public class UpdateAdminServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String username = req.getParameterValues("username")[0];
            String password = req.getParameterValues("password")[0];
            String url=req.getParameterValues("url")[0];
            Long updateTime=Long.parseLong(req.getParameterValues("updateTime")[0]);
            float version = Float.parseFloat(req.getParameterValues("version")[0]);

            boolean forceUpdate = Boolean.parseBoolean(req.getParameterValues("forceUpdate")[0]);
            String updateInfo = req.getParameterValues("updateInfo")[0];
            if (username.equals("")||password.equals("")||updateInfo.equals("")){
                resp.getWriter().print("error");
                return;
            }
            User user=new User(username,password);
            Version versionPatch=new Version();
            versionPatch.setForceUpdate(forceUpdate);
            versionPatch.setVersion(version);
            versionPatch.setUpdateInfo(updateInfo);
            versionPatch.setUpdateTime(updateTime);
            versionPatch.setUrl(url);
            if (!user.getUsername().equals("root")||user.getStatus()!=User.USER_RIGHT)
                return;
            resp.getWriter().print(VersionService.insertVersion(versionPatch));

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
