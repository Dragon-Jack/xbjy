package com.dfbz.servlet;

import com.dfbz.dao.LoginDao;
import com.dfbz.entity.User;
import com.dfbz.tools.Md5;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/reg")
public class RegisteredService extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();

        String name = req.getParameter("name");
        String account = req.getParameter("account");
        String pw = req.getParameter("pw");
        Integer age = Integer.valueOf(req.getParameter("age"));
        String born = req.getParameter("born");

        String md=Md5.encrypt(pw);      //MD5加密

        if (LoginDao.show(account)==""){
            User user = new User(null, name, account, md, age, born);
                    LoginDao.add(user);
            out.println("<script>");
            out.println("alert('注册成功');window.location.href='../login.jsp'");
            out.println("</script>");
        }else {
            out.println("<script>");
            out.println("alert('账号已被注册，请重新注册');window.location.href='html/registered.jsp'");
            out.println("</script>");
        }
    }
}
