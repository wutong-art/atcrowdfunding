package com.wtcode;

import com.wtcode.crowd.entity.Admin;
import com.wtcode.crowd.mapper.AdminMapper;
import com.wtcode.crowd.service.AdminService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author wtcode
 * @date 2021/1/17 - 16:15
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-dao.xml","classpath:spring-service.xml"})
public class CrowdTest {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private AdminMapper adminMapper;

    @Autowired
    private AdminService adminService;

    @Test
    public void testTx(){
        Admin admin = new Admin(null, "jerry", "123", "杰瑞", "jerry@qq.com", null);
        adminService.saveAdmin(admin);



    }


    @Test
    public void testLog(){
        //1.获取Logger对象,这里传入的Class对象就是当前打印日志的类
        Logger logger = LoggerFactory.getLogger(CrowdTest.class);

        //2.根据不同的日志级别来打印日志
        logger.debug("Hello I am Debug level!!!");
        logger.debug("Hello I am Debug level!!!");
        logger.debug("Hello I am Debug level!!!");

        logger.info("Info level");
        logger.info("Info level");
        logger.info("Info level");

        logger.warn("Warn level!!!");
        logger.warn("Warn level!!!");
        logger.warn("Warn level!!!");

        logger.error("Error level");
        logger.error("Error level");
        logger.error("Error level");
    }

    @Test
    public void testConnection() throws SQLException {

        Connection con = dataSource.getConnection();

        //system.out本质上是一个IO操作，通常IO操作是比较消耗性能的，如果项目中的system比较多，那么对性能影响就比较大
        //即时上线前专门花时间删除代码中的system.out,也有可能遗漏，非常麻烦
        //而如果使用日志级别，就可以批量控制信息
        System.out.println(con);
    }

    @Test
    public void testInsertAdmin(){
        Admin admin = new Admin(null, "tom", "123", "汤姆", "tom@qq.com", null);
        int count = adminMapper.insert(admin);
        System.out.println("受影响的行数" + count);
    }

}
