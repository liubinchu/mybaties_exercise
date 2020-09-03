package com.sample;

import com.sample.dao.IAccountDao;
import com.sample.dao.IUserDao;
import com.sample.domain.AccountUser;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.*;

/**
 * @author liubi
 * @date 2020-09-02 17:28
 **/
public class AccountTest {

    private IAccountDao accountDao;
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
        accountDao = session.getMapper(IAccountDao.class);
    }

    @Test
    public void testFindAll() {
//6.执行操作
        List<AccountUser> accountusers = accountDao.findAll();
        for(AccountUser au : accountusers) {
            System.out.println(au);
        }
        assert accountusers.size() == 3;
    }
}
