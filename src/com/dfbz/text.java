package com.dfbz;

import com.dfbz.dao.LoginDao;
import com.dfbz.entity.User;
import com.dfbz.tools.Md5;

import javax.xml.crypto.Data;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class text {

    public static void main(String[] args) throws ParseException {
//LoginDao.update("456789","123");
//        System.out.println(LoginDao.select("456789"));
//        User user=new User(null,"强子",789789,"123",23,null);
//       LoginDao.add(user);

        System.out.println(Md5.encrypt("123456"));
    }
}
