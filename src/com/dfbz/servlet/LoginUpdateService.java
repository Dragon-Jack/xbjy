package com.dfbz.servlet;

import com.dfbz.dao.LoginDao;
import com.dfbz.tools.Md5;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login/update")
public class LoginUpdateService extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        PrintWriter out = resp.getWriter();

        String account = req.getParameter("account");
        String newpw = req.getParameter("pw");             //获取新密码

        Integer s = (int) session.getAttribute("code");//获取session
        Integer verification =Integer.valueOf(req.getParameter("verification"));

        String pw = LoginDao.select(account);     //数据库通过账号查密码
        String md = Md5.encrypt(newpw);


        if (s == null) {
            out.write("3");     //验证码过期
        } else
        if (!newpw.equals(pw)) {
            if (verification.equals(s)) {
                LoginDao.update(account, md);        //通过数据库修改密码
                out.write("2");             //跳转
            } else {
                out.write("0");     //验证码错误
            }
        } else {
            out.write("1");     //新密码跟久密码一致
        }
    }
}
