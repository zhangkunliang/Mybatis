import com.zhang.dao.BlogMapper;
import com.zhang.pojo.Blog;
import com.zhang.util.IDUtils;
import com.zhang.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;

import java.util.Date;
import java.util.HashMap;
import java.util.List;


public class MyTest {
    public static Logger logger = LoggerFactory.getLogger(MyTest.class);
    @Test
    public void addInitBlog(){
        SqlSession session = MybatisUtil.getSession();
        BlogMapper mapper = session.getMapper(BlogMapper.class);

        Blog blog = new Blog();
        blog.setId(IDUtils.getID());
        blog.setTitle("Mybatis如此简单");
        blog.setAuthor("狂神说");
        blog.setCreateTime(new Date());
        blog.setViews(9999);

        mapper.addBlog(blog);

        blog.setId(IDUtils.getID());
        blog.setTitle("Java如此简单");
        mapper.addBlog(blog);

        blog.setId(IDUtils.getID());
        blog.setTitle("Spring如此简单");
        mapper.addBlog(blog);

        blog.setId(IDUtils.getID());
        blog.setTitle("微服务如此简单");
        mapper.addBlog(blog);
        //session.commit();
        session.close();
    }
    @Test
    public void testQueryBlogIf(){
        SqlSession session = MybatisUtil.getSession();
        BlogMapper mapper = session.getMapper(BlogMapper.class);

        HashMap<String, String> map = new HashMap<String, String>();
        map.put("title","Mybatis如此简单");
        map.put("author","狂神说");
        List<Blog> blogs = mapper.queryBlogIf(map);

        System.out.println(blogs);

        session.close();
    }
}
