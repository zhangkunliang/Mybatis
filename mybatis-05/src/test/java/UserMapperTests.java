import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import com.zhang.dao.UserMapper;
import com.zhang.pojo.User;
import com.zhang.util.MybatisUtil;

import java.util.List;

public class UserMapperTests {
    @Test
    public void test(){
        SqlSession session = MybatisUtil.getSqlSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        List<User> users = mapper.getUsers();
        for(User user:users){
            System.out.println(user);
        }
        session.close();
    }
    }

