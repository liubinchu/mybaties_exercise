package com.sample;

import com.sample.dao.IUserDao;
import com.sample.domain.QueryVo;
import com.sample.domain.QueryVoIds;
import com.sample.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.*;

/**
 * @author liubi
 * @date 2020-09-02 15:44
 **/
public class UserDaoCrudTests {
    private InputStream in;
    private SqlSessionFactory factory;
    private SqlSession session;
    private IUserDao userDao;

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
        userDao = session.getMapper(IUserDao.class);
    }

    @Test
    public void testFindOne() {
// 6.执行操作
        User user = userDao.findById(41);
        System.out.println(user);
        assert user.getUserName().equals("张三");
    }

    @Test
    public void testSave() {
        User user = new User();
        user.setUserName("华泰");
        user.setUserAddress("南京市建邺区");
        user.setUserSex("男");
        user.setUserBirthday(new Date());
// 1.执行保存方法
        int id = userDao.saveUser(user);
// 2. 验证保存结果
        User savedUser = userDao.findById(id);
        assert user.getUserName().equals("华泰");
    }

    @Test
    public void testUpdateUser() {
        int id = 46;
//1.根据id查询
        User user = userDao.findById(id);
//2.更新操作
        user.setUserAddress("北京市顺义区");
        int res = userDao.updateUser(user);
// 3. 验证保存结果
        User savedUser = userDao.findById(id);
        assert user.getUserAddress().equals("北京市顺义区");
    }
    @Test
    public void testDeleteUser() {
/*// 1.执行操作
        int res = userDao.deleteUser(61);
        assert res == 1;*/
    }

    @Test
    public void testFindByName() {
// 1.执行查询一个方法
        List<User> users = userDao.findByName("%王%");
        assert users.size() == 2;
        for(User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void testFindByNameNew() {
// 1.执行查询一个方法
        List<User> users = userDao.findByNameNew("王");
        assert users.size() == 2;
        for(User user : users){
            System.out.println(user);
        }
    }

/*    @Test
    public void testCount() {
// 1.执行操作
        int res = userDao.count();
        assert res == 15;
    }*/

    @Test
    public void testQueryByVo() {
        QueryVo vo = new QueryVo();
        vo.setName("%王%");
        vo.setAddress("%南京%");
        List<User> users = userDao.findByVo(vo);
        assert users.size() == 1;
    }

    @Test
    public void testQueryByVo_withoutAddress() {
        QueryVo vo = new QueryVo();
        vo.setName("%王%");
        vo.setAddress(null);
        List<User> users = userDao.findByVo(vo);
        assert users.size() == 2;
    }

    @Test
    public void testFindInIds() {
        QueryVoIds voIds = new QueryVoIds();
        List<Integer> ids = new ArrayList<Integer>();
        ids.add(62);
        ids.add(63);
        ids.add(64);
        ids.add(65);
        voIds.setIds(ids);
        List<User> users = userDao.findInIds(voIds);
        assert users.size() == 4;
    }

    @After
    public void tearDown() throws Exception {
        session.commit();
//7.释放资源
        session.close();
        in.close();
    }
}
