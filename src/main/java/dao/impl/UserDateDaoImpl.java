package dao.impl;

import dao.UserDateDao;
import entity.UserDate;
import util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

public class UserDateDaoImpl implements UserDateDao {
    public void addUserDate(UserDate Date){
        SqlSession sqlSession= MybatisUtil.getSqlSession(true);
        sqlSession.getMapper(UserDateDao.class).addUserDate(Date);
    }
    public UserDate showUserDate(String UserId){
        SqlSession sqlSession=MybatisUtil.getSqlSession(true);
        return sqlSession.getMapper(UserDateDao.class).showUserDate(UserId);
    }
    public void changeUserDate(UserDate Date){
        SqlSession sqlSession=MybatisUtil.getSqlSession(true);
        sqlSession.getMapper(UserDateDao.class).changeUserDate(Date);
    }
}
