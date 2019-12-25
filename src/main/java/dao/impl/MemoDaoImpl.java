package dao.impl;

import dao.MemoDao;
import entity.memo;
import util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

public class MemoDaoImpl implements MemoDao{
    public void addMemo(memo Memo){
        SqlSession sqlSession= MybatisUtil.getSqlSession(true);
        sqlSession.getMapper(MemoDao.class).addMemo(Memo);
    }
    public void deleMemo(String MemoId){
        SqlSession sqlSession=MybatisUtil.getSqlSession(true);
        sqlSession.getMapper(MemoDao.class).deleMemo(MemoId);
    }
    public memo[] findMemoBN(String Title){
        SqlSession sqlSession=MybatisUtil.getSqlSession(true);
        return sqlSession.getMapper(MemoDao.class).findMemoBN(Title);
    }
    public memo findMemoBI(String MemoId){
        SqlSession sqlSession=MybatisUtil.getSqlSession(true);
        return sqlSession.getMapper(MemoDao.class).findMemoBI(MemoId);
    }
    public memo[] allMemo(){
        SqlSession sqlSession=MybatisUtil.getSqlSession(true);
        return sqlSession.getMapper(MemoDao.class).allMemo();
    }
    public void changeMemo(memo Memo){
        SqlSession sqlSession=MybatisUtil.getSqlSession(true);
        sqlSession.getMapper(MemoDao.class).changeMemo(Memo);
    }
}
