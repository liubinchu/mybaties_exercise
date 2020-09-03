package com.sample;

import com.sample.dao.IRoleDao;
import com.sample.domain.Role;
import org.junit.Assert;
import org.junit.Test;
import java.util.*;

/**
 * @author liubi
 * @date 2020-09-02 17:40
 **/
public class RoleTest {
    private IRoleDao roleDao;
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
