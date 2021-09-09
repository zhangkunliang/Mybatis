package dao;

import com.zhang.dao.UserDao;
import com.zhang.pojo.User;
import com.zhang.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserDaoTest {
    @Test
    public void test(){
        //第一步：获得SqlSession对象
        SqlSession sqlSession  = MybatisUtil.getSqlSession();
        try{
            //方式一：getMapper
            UserDao userDao = sqlSession.getMapper(UserDao.class);
            List<User> userList = userDao.getUserList();
            for (User user:userList){
                System.out.println(user);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //关闭sqlsession
            sqlSession.close();
        }


    }
    @Test
    public void testInsert(){
        SqlSession sqlSession  = MybatisUtil.getSqlSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        User user = new User();
        user.setId(1);
        user.setName("com.zhang");
        user.setPwd("123");
        userDao.insertUser(user);
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void testGetUserById(){

        SqlSession sqlSession  = MybatisUtil.getSqlSession();
        UserDao dao = sqlSession.getMapper(UserDao.class);
        Map<String ,Object> map = new HashMap<>();
        map.put("userid",1);
        map.put("name","com.zhang");
        dao.getUserById(map);
        sqlSession.commit();
        sqlSession.close();


    }
    @Test
    public void getUserLike(){
        SqlSession sqlSession  = MybatisUtil.getSqlSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        List<User> userList = userDao.getUserLike("%李%");
        for (User user:userList
             ) {
            System.out.println(user);

        }
        sqlSession.close();
    }
    @Test
    public void testSelectUser(){
        SqlSession session = MybatisUtil.getSqlSession();
        UserDao dao = session.getMapper(UserDao.class);
        int currentPage = 1;
        int pageSize = 2;
        Map<String ,Integer> map = new HashMap<String,Integer>();
        map.put("startIndex",(currentPage-1)*pageSize);
        map.put("pageSize",pageSize);
        List<User> users = dao.selectUser(map);
        for(User user:users){
            System.out.println(user);
        }
        session.close();
    }

}
