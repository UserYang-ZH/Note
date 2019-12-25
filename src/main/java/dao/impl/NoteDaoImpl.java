package dao.impl;

import dao.NoteDao;
import entity.note;
import util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

public class NoteDaoImpl implements NoteDao{
    public void addNote(note Note){
        SqlSession sqlSession= MybatisUtil.getSqlSession(true);
        sqlSession.getMapper(NoteDao.class).addNote(Note);
    }
    public note[] allNote(){
        SqlSession sqlSession=MybatisUtil.getSqlSession(true);
        return sqlSession.getMapper(NoteDao.class).allNote();
    }
    public void deleNote(String NoteId){
        SqlSession sqlSession=MybatisUtil.getSqlSession(true);
        sqlSession.getMapper(NoteDao.class).deleNote(NoteId);
    }
    public note[] findNoteBN(String Title){
        SqlSession sqlSession=MybatisUtil.getSqlSession(true);
        return sqlSession.getMapper(NoteDao.class).findNoteBN(Title);
    }
    public note findNoteBI(String NoteId){
        SqlSession sqlSession=MybatisUtil.getSqlSession(true);
        return sqlSession.getMapper(NoteDao.class).findNoteBI(NoteId);
    }
    public void changeNote(note Note){
        SqlSession sqlSession=MybatisUtil.getSqlSession(true);
        sqlSession.getMapper(NoteDao.class).changeNote(Note);
    }
}
