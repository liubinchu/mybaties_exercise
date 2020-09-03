package com.sample;

import static org.junit.Assert.assertTrue;

import com.sample.dao.IUserDao;
import com.sample.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.util.*;

import java.io.InputStream;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() throws IOException {
        // 1.读取配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
//2.创建SqlSessionFactory的构建者对象
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
//3.使用构建者创建工厂对象SqlSessionFactory
        SqlSessionFactory factory = builder.build(in);
//4.使用SqlSessionFactory生产SqlSession对象
        SqlSession session = factory.openSession();
//5.使用SqlSession创建dao接口的代理对象
        IUserDao userDao = session.getMapper(IUserDao.class);
//6.使用代理对象执行查询所有方法
        List<User> users = userDao.findAll();
        for(User user : users) {
            System.out.println(user);
        }
//7.释放资源
        session.close(); in.close();
        assertTrue( true );
    }
}