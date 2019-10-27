package com.dfbz.servlet;

import com.dfbz.tools.PicUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;

@WebServlet("/pic")
public class PicService extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PicUtil ivc = new PicUtil();     //用我们的验证码类，生成验证码类对象
        BufferedImage image = ivc.getImage();  //获取验证码
        req.getSession().setAttribute("text", ivc.getText()); //将验证码的文本存在session中
        ivc.output(image, resp.getOutputStream());//将验证码图片响应给客户端
        String session_vcode=(String) req.getSession().getAttribute("text");    //从session中获取真正的验证码




    }
}
