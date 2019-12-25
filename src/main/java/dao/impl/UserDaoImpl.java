package dao.impl;

import dao.UserDao;
import entity.user;
import util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

public class UserDaoImpl implements UserDao {
    @Override
    public void addUser(user User){
        try(SqlSession sqlSession = MybatisUtil.getSqlSession(true)) {
        sqlSession.getMapper(UserDao.class).addUser(User);
        }catch (RuntimeException e){
            throw e;
        }
    }
    @Override
    public user[] findUser(String UserName){
        try(SqlSession sqlSession=MybatisUtil.getSqlSession(true)){
           return sqlSession.getMapper(UserDao.class).findUser(UserName);
        }catch (RuntimeException e){
            throw e;
        }
    }

    @Override
    public user[] allUser() {
        try(SqlSession sqlSession=MybatisUtil.getSqlSession(true)){
            return sqlSession.getMapper(UserDao.class).allUser();
        }catch (RuntimeException e){
            throw e;
        }
    }
    @Override
    public void changeUser(user User){
        try(SqlSession sqlSession=MybatisUtil.getSqlSession(true)) {
            sqlSession.getMapper(UserDao.class).changeUser(User);
        }catch (RuntimeException e){
            throw e;
        }
    }
}
