import com.zhang.dao.StudentMapper;
import com.zhang.dao.TeacherMapper;
import com.zhang.pojo.Student;
import com.zhang.pojo.Teacher;
import com.zhang.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.omg.CORBA.PUBLIC_MEMBER;

import java.util.List;

public class MyTest {
    @Test
    public void testGetTeacher(){
        SqlSession session = MybatisUtil.getSession();
        TeacherMapper mapper = session.getMapper(TeacherMapper.class);
        Teacher teacher = mapper.getTeacher(1);
        System.out.println(teacher.getName());
        System.out.println(teacher.getStudents());
    }
}
