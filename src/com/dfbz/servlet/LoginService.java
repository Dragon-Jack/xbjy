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

@WebServlet("/login")
public class LoginService extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LoginDao l = new LoginDao();
        PrintWriter out = resp.getWriter();

        String session_vcode = ((String) req.getSession().getAttribute("text")).toLowerCase();      //获取图片内容后转成小写
        String pic = (req.getParameter("pic")).toLowerCase();       //把图片验证文本框内容转成小写
        String account = req.getParameter("account");
        String free = req.getParameter("free");                 //获取功能按钮值，免登录
        String pw = Md5.encrypt(req.getParameter("pw"));      //把文本框密码加密
        String s = l.select(account);       //通过账号从数据库查密码
//        if (req.getSession().getAttributeNames().equals("account")){
//            System.out.println(789);
//        }
        System.out.println(req.getSession().getAttributeNames().toString().equals("account"));
//        System.out.println(req.getSession().getAttribute("account"));
        
           if (s.equals(pw) && session_vcode.equals(pic)) {
               if (free.equals("1")){
                   HttpSession session=req.getSession();
                   session.setAttribute("account",account);
               }
               out.write("0");          //登录成功,图片验证跟密码都通过
//           resp.sendRedirect("html/main.jsp");
           } else if (!s.equals(pw) || s.equals(null) || s.equals("")) {
               out.write("1");     //密码不正确，或者为空
           } else if (!session_vcode.equals(pic)) {
               out.print("2");     //图片验证不正确
           }


    }
}
