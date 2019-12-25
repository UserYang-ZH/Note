package dao.impl;

import dao.ColorDao;
import entity.color;
import util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

public class ColorDaoImpl implements ColorDao{
    public void addColor(color Color){
        SqlSession sqlSession= MybatisUtil.getSqlSession(true);
        sqlSession.getMapper(ColorDao.class).addColor(Color);
    }
    public color showColor(String UserId){
        SqlSession sqlSession= MybatisUtil.getSqlSession(true);
        return sqlSession.getMapper(ColorDao.class).showColor(UserId);
    }
    public void changeColor(color Color){
        SqlSession sqlSession=MybatisUtil.getSqlSession(true);
        sqlSession.getMapper(ColorDao.class).changeColor(Color);
    }
}
