package com.dfbz.servlet;

import com.dfbz.tools.Email;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;

@WebServlet("/email")
public class EmailService extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out=resp.getWriter();
        String email=req.getParameter("email");


//        if (email.equals("")||email.equals(null)){
//            out.write("1");
//        }else {
            int code=(int)((Math.random()*9+1)*1000);

            Email.send(email,code);
            HttpSession session=req.getSession();
            session.setAttribute("code",code);
            session.setMaxInactiveInterval(60);
            out.write("0");
//        }
    }
}
