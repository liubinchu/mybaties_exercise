package com.sample;

import com.sample.dao.IAccountDao;
import com.sample.dao.IRoleDao;
import com.sample.domain.Role;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.omg.CORBA.IRObject;

import java.io.InputStream;
import java.util.*;

/**
 * @author liubi
 * @date 2020-09-02 17:40
 **/
public class RoleTest {
    private IRoleDao roleDao;
    private InputStream in;
    private SqlSessionFactory factory;
    private SqlSession session;

    @Before
    public void setUp() throws Exception {
// 1.读取配置文件
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
// 2.创建构建者对象
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
// 3.创建SqlSession工厂对象
        factory = builder.build(in);
// 4.创建SqlSession对象
        session = factory.openSession();
        // 5.创建Dao的代理对象
        roleDao = session.getMapper(IRoleDao.class);
    }
    @Test
    public void testFindAll() {
        List<Role> roles = roleDao.findAll();
        Assert.assertEquals(3, roles.size());
        for(Role role : roles){
            System.out.println("---每个角色的信息----");
            System.out.println(role);
            System.out.println(role.getUsers());
        }
    }
}
