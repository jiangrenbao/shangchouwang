import com.alibaba.raise.entity.Admin;
import com.alibaba.raise.mapper.AdminMapper;

import com.alibaba.raise.service.AdminService;
import com.alibaba.raise.util.RaiseUtil;
import com.sun.xml.internal.xsom.impl.scd.SCDImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import sun.tools.java.ClassPath;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * parkerJ
 * 2021/10/21
 * description：
 * function：
 */
// spring整合Junit后,IOC容器中的bean在类中可以注入
@RunWith(SpringJUnit4ClassRunner.class)
/*"classpath:spring-tx.xml"*/
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
public class DatasourceTest {
    @Resource
    private DataSource dataSource;

    @Test
    public void connectTest() throws SQLException {
        System.out.println(dataSource.getConnection());
    }

    @Resource
    private AdminMapper adminMapper;

    @Test
    public void testMapper(){
        Admin admin = new Admin(1, "admin", "123", "parker", "123@qq.com", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        System.out.println(adminMapper.insertAdmin(admin));
    }
}
