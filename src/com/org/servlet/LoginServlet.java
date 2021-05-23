package com.org.servlet;

import com.org.DebugMain;
import com.org.entity.UserInfo;
import com.org.impl.UserinfoServiceImpl;
import com.org.services.UserinfoService;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String usercode = request.getParameter("usercode");
        String userpwd = request.getParameter("userpwd");

        System.out.println(usercode);
        System.out.println(userpwd);

        UserinfoService userinfoService = new UserinfoServiceImpl();
        UserInfo userInfo = userinfoService.login(usercode, userpwd);

        String result = "登录失败";

        if (userInfo != null) result = "登录成功";

        response.setContentType("text/html;charset=utf-8");
        response.getWriter().write("<h2>" + result + "</h2>");


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

}
