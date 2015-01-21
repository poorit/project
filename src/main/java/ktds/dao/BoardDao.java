package ktds.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ktds.domain.Board;
@Repository
public class BoardDao {
  @Autowired
  SqlSessionFactory sqlSessionFactory;
  public List<Board> selectList()
  {
   
    SqlSession sqlSession = sqlSessionFactory.openSession();
    
    try{
      return sqlSession.selectList("ktds.dao.BoardDao.selectList");
      
    } catch (Exception e) {
      e.printStackTrace();
      return null;
      

    }finally
    {
     sqlSession.close();
    }
  }
  public void insert(Board board)
  {
    SqlSession sqlSession = sqlSessionFactory.openSession();
    
    try{
      sqlSession.insert("ktds.dao.BoardDao.insert", board);
      sqlSession.commit();
      
      
    } catch (Exception e) {
      e.printStackTrace();

    }finally
    {
      
      try {
        sqlSession.close();
      } catch (Exception e) {}
    }
  }
  
  public void delete(int num)
  {
    SqlSession sqlSession = sqlSessionFactory.openSession();
    try{
      sqlSession.delete("ktds.dao.BoardDao.delete", num);
      sqlSession.commit();
      
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();

    }finally
    {
      
      try {
        sqlSession.close();
      } catch (Exception e) {}
    }
  }
  
  public Board selectOne(int num)
  {
    SqlSession sqlSession = sqlSessionFactory.openSession();
    try {
     return sqlSession.selectOne("ktds.dao.BoardDao.selectOne",num);
     
    } catch (Exception e) {
      e.printStackTrace();
      return null;

    }finally
    {
      sqlSession.close();
      
    }
   
  }
 
  public void update(Board board)
  {
    SqlSession sqlSession = sqlSessionFactory.openSession();
    try{
      sqlSession.update("ktds.dao.BoardDao.update", board);
      sqlSession.commit();
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();

    }finally
    {
      
      try {
        sqlSession.close();
      } catch (Exception e) {}
    }
  }
  
  
}
