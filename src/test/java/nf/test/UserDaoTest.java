package nf.test;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import entity.user;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UserDaoTest {
    @Test
    public void testAddUser(){
        UserDao dao=new UserDaoImpl();
        user a=new user();
        a.setUserId("yh000001");
        a.setUserName("客观");
        a.setEmail("247799864@qq.com");
        a.setPhNumber("17765884613");
        a.setPwd("qwsdfv1");
        dao.addUser(a);
    }
    @Test
    public void testFindUser(){
        UserDao dao=new UserDaoImpl();
        user[] User=dao.findUser("客观");
        System.out.println(User[0].getUserId()+"\t"+User[0].getEmail());
    }
    @Test
    public void text() throws ParseException {
        SimpleDateFormat date=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String a="2019-12-24 19:00:00";
        String b="0000-00-00 03:00:00";
        Date A=date.parse(a);
        Date B=date.parse(b);
        long c=A.getTime()-B.getTime();
        double d=c / 3600000/24/366.0;
        System.out.println(d);
    }
}
